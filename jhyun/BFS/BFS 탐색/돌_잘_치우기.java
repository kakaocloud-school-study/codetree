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
    static final int MAX_N = 100;

    static int n, k, m;
    static int[][] grid = new int[MAX_N][MAX_N];

    static int ans;
    static List<Pair> sPos = new ArrayList<>();
    static List<Pair> stonePos = new ArrayList<>();
    static List<Pair> selectedStones = new ArrayList<>();

    static Queue<Pair> queue = new LinkedList<>();
    static boolean[][] visited = new boolean[MAX_N][MAX_N];

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 0 && !visited[x][y];
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            Pair currPos = queue.poll();
            int x = currPos.x;
            int y = currPos.y;

            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    queue.add(new Pair(newX, newY));
                    visited[newX][newY] = true;
                }
            }

        }
    }

    static int calc() {
        for (int i = 0; i < m; i++) {
            int x = selectedStones.get(i).x;
            int y = selectedStones.get(i).y;
            grid[x][y] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        //k개의 시작점을 queue에 넣고 시작
        //BFS는 여러 시작점에서 시작하여 이동 가능한 칸을 전부 탐색
        for (int i = 0; i < k; i++) {
            queue.add(sPos.get(i));
            visited[sPos.get(i).x][sPos.get(i).y] = true;
        }

        BFS();

        for (int i = 0; i < m; i++) {
            int x = selectedStones.get(i).x;
            int y = selectedStones.get(i).y;
            grid[x][y] = 1;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void findMax(int idx, int cnt) {
        if (idx == (int) stonePos.size()) {
            if (cnt == m) {
                ans = Math.max(ans, calc());
            }
            return;
        }

        selectedStones.add(stonePos.get(idx));
        findMax(idx + 1, cnt + 1);
        selectedStones.remove(selectedStones.size() - 1);

        findMax(idx + 1, cnt);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    stonePos.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            r--;
            c--;
            sPos.add(new Pair(r, c));
        }

        findMax(0, 0);

        System.out.print(ans);
    }
}