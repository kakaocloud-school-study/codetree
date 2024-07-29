import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100;

    static int n;
    static int[][] num = new int[MAX_N][MAX_N];
    static int[][] memo = new int[MAX_N][MAX_N];

    static void init() {
        memo[0][0] = num[0][0];

        for (int i = 1; i < n; i++) {
            memo[i][0] = memo[i - 1][0] + num[i][0];
        }

        for (int j = 1; j < n; j++) {
            memo[0][j] = memo[0][j - 1] + num[0][j];
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
            for (int j = 1; j < n; j++) {
                memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]) + num[i][j];
            }
        }

        System.out.println(memo[n - 1][n - 1]);
    }
}