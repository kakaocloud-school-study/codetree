import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[] seq = new int[MAX_N];
    static int n, m;

    static boolean isHappySequence() {
        int cnt = 1, maxCnt = 1;

        for (int i = 1; i < n; i++) {
            if (seq[i - 1] == seq[i]) {
                cnt++;
            } else {
                cnt = 1;
            }
            maxCnt = Math.max(cnt, maxCnt);
        }

        return maxCnt >= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int numHappy = 0;

        //가로로 행복한 수열 수 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                seq[j] = grid[i][j];
            }

            if (isHappySequence()) {
                numHappy++;
            }
        }

        //세로로 행복한 수열 수 세기
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                seq[i] = grid[i][j];
            }

            if (isHappySequence()) {
                numHappy++;
            }
        }

        System.out.print(numHappy);
    }
}