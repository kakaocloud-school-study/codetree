import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 1000;

    static int n;
    static int[][] num = new int[MAX_N][MAX_N];
    static int[][] memo = new int[MAX_N][MAX_N];

    static void init() {
        memo[0][n - 1] = num[0][n - 1];

        for (int i = 1; i < n; i++) {
            memo[i][n - 1] = memo[i - 1][n - 1] + num[i][n - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            memo[0][i] = memo[0][i + 1] + num[0][i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for (int i = 1; i < n; i++) {
            for (int j = n - 2; j >= 0; j--) {
                memo[i][j] = Math.min(memo[i - 1][j], memo[i][j + 1]) + num[i][j];
            }
        }

        System.out.print(memo[n - 1][0]);
    }
}