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
    static final int MAX_M = 100;

    static int n;
    static int r1, c1, r2, c2;

    static Queue<Pair> queue = new LinkedList<>();
    static boolean[][] visited = new boolean[MAX_N][MAX_N];
    static int[][] step = new int[MAX_N][MAX_N];

    static int ans = INT_MAX;

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean canGo(int x, int y) {
        return inRange(x, y) && !visited[x][y];
    }

    static void push(int newX, int newY, int newStep) {
        queue.add(new Pair(newX, newY));
        visited[newX][newY] = true;
        step[newX][newY] = newStep;
    }

    static void findMin() {
        while (!queue.isEmpty()) {
            Pair currPos = queue.poll();
            int x = currPos.x;
            int y = currPos.y;

            int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
            int[] dy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    push(newX, newY, step[x][y] + 1);
                }
            }
        }

        if (visited[r2][c2]) {
            ans = step[r2][c2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        r1--;
        c1--;
        r2--;
        c2--;

        push(r1, c1, 0);
        findMin();

        if (ans == INT_MAX) {
            ans = -1;
        }

        System.out.print(ans);
    }
}