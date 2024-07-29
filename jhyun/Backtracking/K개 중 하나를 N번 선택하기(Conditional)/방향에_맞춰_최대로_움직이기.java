import java.util.*;
import java.io.*;

public class Main {
    static final int DIR_NUM = 8;
    static final int MAX_N = 4;

    static int n;
    static int[][] nums = new int[MAX_N][MAX_N];
    static int[][] moveDir = new int[MAX_N][MAX_N];
    static int ans;

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean canGo(int x, int y, int prevNum) {
        return inRange(x, y) && nums[x][y] > prevNum;
    }

    static void findMax(int x, int y, int cnt) {
        ans = Math.max(ans, cnt);

        int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int d = moveDir[x][y] - 1;

        for (int i = 0; i < n; i++) {
            int nx = x + dx[d] * i;
            int ny = y + dy[d] * i;

            if (canGo(nx, ny, nums[x][y])) {
                findMax(nx, ny, cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        findMax(r - 1, c - 1, 0);
        System.out.print(ans);
    }
}