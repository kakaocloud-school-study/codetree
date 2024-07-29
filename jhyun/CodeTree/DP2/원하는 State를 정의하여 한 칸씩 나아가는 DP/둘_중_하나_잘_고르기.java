import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MIN = Integer.MIN_VALUE;
    static final int MAX_N = 100;

    static int n;
    static int[] red = new int[MAX_N * 2 + 1];
    static int[] blue = new int[MAX_N * 2 + 1];
    //dp[i][j] : i번째 카드 쌍까지 고려했을 때 지금까지 빨간색 카드를 정확히 j장 뽑았다 했을 때
    //얻을 수 있는 뽑힌 숫자들의 최대 합
    static int[][] dp = new int[MAX_N * 2 + 1][MAX_N * 2 + 1];

    static void init() {
        for (int i = 0; i <= 2 * n; i++) {
            for (int j = 0; j <= 2 * n; j++) {
                dp[i][j] = INT_MIN;
            }
        }
        dp[0][0] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 2 * n; i++) {
            st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for (int i = 1; i <= 2 * n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + red[i]);
                }
                if (i - j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + blue[i]);
                }
            }
        }

        System.out.println(dp[2 * n][n]);
    }
}