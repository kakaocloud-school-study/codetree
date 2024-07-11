package lim.시뮬레이션;

import java.util.HashMap;
import java.util.Scanner;

public class 격자_안에서_여러_객체를_이동_벽이_없는_충돌_실험 {
    private static final int MAX_X = 4000;
    private static int[][] grid = new int[MAX_X + 1][MAX_X + 1];
    private static int[][] newGrid = new int[MAX_X + 1][MAX_X + 1];
    private static Game game;

    public static class Ball {
        int w, direction, id, x, y;
        boolean crash = false;
        static int nextId = 0;

        Ball(int w, int direction, int x, int y) {
            this.w = w;
            this.direction = direction;
            this.id = nextId++;
            this.x = x;
            this.y = y;
        }

        Ball max(Ball other) {
            if (this.w == other.w) {
                if (this.id < other.id) {
                    return other;
                } else {
                    return this;
                }
            } else if (this.w < other.w) {
                return other;
            } else {
                return this;
            }
        }

        public String toString() {
            return "w: " + w + ",direction: " + direction + ",id: " + id;
        }
    }

    public static class Game {
        Ball[] balls;
        int[] dxs = { -1, 1, 0, 0 };
        int[] dys = { 0, 0, -1, 1 };
        int time = 0;
        int crashAt = -1;

        Game(Ball[] balls) {
            this.balls = balls;
        }

        boolean inRange(int r, int c) {
            return r >= 0 && c >= 0 && r < MAX_X + 1 && c < MAX_X + 1;
        }

        void move(int[][] newGrid, Ball ball) {
            if (ball.crash) {
                return;
            }
            int nx = ball.x + dxs[ball.direction];
            int ny = ball.y + dys[ball.direction];
            grid[ball.x][ball.y] = -1;

            if (!inRange(nx, ny)) {
                return;
            }

            if (newGrid[nx][ny] != -1) {
                int oldBallId = newGrid[nx][ny];
                Ball oldBall = balls[oldBallId];
                Ball winner = ball.max(oldBall);
                if (winner.id == ball.id) {
                    oldBall.crash = true;
                } else {
                    ball.crash = true;
                }
                newGrid[nx][ny] = winner.id;
                crashAt = time;
            } else {
                newGrid[nx][ny] = ball.id;
            }

            ball.x = nx;
            ball.y = ny;
        }

        void moveAll() {
            time++;
            for (Ball ball : balls) {
                move(newGrid, ball);
            }

            int[][] tmp = grid;
            grid = newGrid;
            newGrid = tmp;
        }

        void printCrashAt() {
            System.out.println(crashAt);
        }
    }

    private static void sol() {
        for (int i = 0; i < MAX_X; i++) {
            game.moveAll();
        }
        game.printCrashAt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        HashMap<String, Integer> directionMapper = new HashMap<>();
        directionMapper.put("L", 0);
        directionMapper.put("R", 1);
        directionMapper.put("D", 2);
        directionMapper.put("U", 3);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = -1;
                newGrid[i][j] = -1;
            }
        }
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            Ball[] balls = new Ball[n];
            Ball.nextId = 0;
            for (int j = 0; j < n; j++) {
                int x = scanner.nextInt() * 2 + 2000;
                int y = scanner.nextInt() * 2 + 2000;
                int w = scanner.nextInt();
                String direction = scanner.next();
                Ball ball = new Ball(w, directionMapper.get(direction), x, y);
                grid[x][y] = ball.id;
                balls[j] = ball;
            }
            game = new Game(balls);
            sol();
            for (int j = 0; j < n; j++) {
                Ball ball = balls[j];
                int x = ball.x;
                int y = ball.y;
                grid[x][y] = -1;
            }
        }
        scanner.close();
    }
}
