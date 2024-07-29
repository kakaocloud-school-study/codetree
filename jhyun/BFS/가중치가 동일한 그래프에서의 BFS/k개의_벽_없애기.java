import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int MAX_N = 100;

    static int n, k;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int r1, c1, r2, c2;
    static List<Pair> stonePos = new ArrayList<>();

    static Queue<Pair> queue = new LinkedList<>();
    static boolean[][] visited = new boolean[MAX_N][MAX_N];
    static int[][] step = new int[MAX_N][MAX_N];

    static int ans = INT_MAX;

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 0 && !visited[x][y];
    }

    static void push(int newX, int newY, int newStep) {
        queue.add(new Pair(newX, newY));
        visited[newX][newY] = true;
        step[newX][newY] = newStep;
    }

    static int BFS() {
        while (!queue.isEmpty()) {
            Pair currPos = queue.poll();

            int x = currPos.x;
            int y = currPos.y;

            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    push(newX, newY, step[x][y] + 1);
                }
            }
        }

        if (visited[r2][c2]) {
            return step[r2][c2];
        } else {
            return INT_MAX;
        }
    }

    static void findMin(int idx, int cnt) {
        if (idx == stonePos.size()) {
            if (cnt == k) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        visited[i][j] = false;
                        step[i][j] = 0;
                    }
                }

                push(r1, c1, 0);
                int minDist = BFS();
                ans = Math.min(minDist, ans);
            }
            return;
        }

        grid[stonePos.get(idx).x][stonePos.get(idx).y] = 0;
        findMin(idx + 1, cnt + 1);
        grid[stonePos.get(idx).x][stonePos.get(idx).y] = 1;

        findMin(idx + 1, cnt);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] > 0) {
                    stonePos.add(new Pair(i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r1--;
        c1--;
        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        r2--;
        c2--;

        findMin(0, 0);

        if (ans == INT_MAX) {
            ans = -1;
        }

        System.out.print(ans);
    }
}