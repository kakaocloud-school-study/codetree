import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MIN = Integer.MIN_VALUE;
    static final int MAX_N = 1000;

    static int n;
    static int[] dp = new int[MAX_N + 1];
    static int[] arr = new int[MAX_N + 1];

    static void init() {
        for (int i = 0; i <= n; i++) {
            dp[i] = INT_MIN;
        }

        dp[0] = 0;
        arr[0] = 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for (int i = 1; i <= n; i++) {
            // i번째보다 앞에 있는 원소들 중 arr[i]보다는 값이 작은 곳을 골라 바로 그 뒤에
            // 새로운 원소인 arr[i]를 추가했을 때의 부분 수열 중 최대 부분 수열의 길이를 계산
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}