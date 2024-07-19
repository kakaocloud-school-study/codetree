package lim.시뮬레이션;

import java.util.HashMap;
import java.util.Scanner;

public class 격자_안에서_터지고_떨어지는_경우_단_한_번의_2048_시도 {
    private static final int GRID_SIZE = 4;
    private static int direction;
    private static Game game;

    public static class Game {
        int[][] grid;

        Game(int[][] grid) {
            this.grid = grid;
        }

        void rotate(int count) {
            if (count == 0) {
                return;
            }
            int[][] newGrid = new int[GRID_SIZE][GRID_SIZE];
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    newGrid[j][GRID_SIZE - 1 - i] = grid[i][j];
                }
            }
            grid = newGrid;
            if (count > 1) {
                rotate(count - 1);
            }
        }

        void go() {
            rotate(direction);
            int[][] newGrid = new int[GRID_SIZE][GRID_SIZE];
            for (int j = 0; j < GRID_SIZE; j++) {
                int cursor = GRID_SIZE - 1;
                for (int i = GRID_SIZE - 1; i >= 0; i--) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    if (newGrid[cursor][j] == 0) { // 커서 위치가 비었다면 그대로 넣고 커서 이동은 일단 보류(똑같은 숫자가 있을 수 있음)
                        newGrid[cursor][j] = grid[i][j];
                        continue;
                    }

                    if (newGrid[cursor][j] == grid[i][j]) { // 똑같은 숫자가 오면 현재 커서에 또 더해주고 커서 이동. 다르다면 커서 이동후 빈 위치에 삽입
                        newGrid[cursor][j] += grid[i][j];
                        cursor--;
                    } else {
                        cursor--;
                        newGrid[cursor][j] += grid[i][j];
                    }
                }
            }
            grid = newGrid;
            rotate(4 - direction);
        }

        void printGrid() {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    System.out.printf("%d ", grid[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void sol() {
        game.go();
        game.printGrid();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        game = new Game(grid);
        HashMap<String, Integer> directionMapper = new HashMap<>();
        directionMapper.put("D", 0);
        directionMapper.put("R", 1);
        directionMapper.put("U", 2);
        directionMapper.put("L", 3);
        direction = directionMapper.get(scanner.next());
        sol();
        scanner.close();
    }
}
