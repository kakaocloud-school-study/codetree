import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MIN = Integer.MIN_VALUE;
    static final int MAX_N = 1000;

    static int n;
    static int[] dp = new int[MAX_N];
    static int[] arr = new int[MAX_N];

    static void init() {
        for (int i = 0; i < n; i++) {
            dp[i] = INT_MIN;
        }

        dp[0] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == INT_MIN) {
                    continue;
                }

                if (j + arr[j] >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);

    }
}