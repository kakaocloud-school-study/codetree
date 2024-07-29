import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] a = new int[1005][5];
    static int[][] dp = new int[1005][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 1;i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 동적 프로그래밍을 사용하여 최대 점수를 계산
        // dp[i][j] : i번째 층까지 올라왔을 때, j번 방(j = 1일 때 : 왼쪽, j = 2일 때 : 가운데, j = 3일 때 : 오른쪽)
        // 을 골랐을 때 가져갈 수 있는 보물의 최대 개수
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= 3; j++) {
                for(int k = 1; k <= 3; k++) {
                    // 이전 층과 같은 방을 고르지 않는 경우에 대해 계산
                    if(j != k){
                        dp[i+1][k] = Math.max(dp[i+1][k], dp[i][j] + a[i+1][k]);
                    }
                }
            }
        }

        int ans = 0;
        for(int j = 1; j <= 3; j++) {
            ans = Math.max(ans, dp[n][j]);
        }
        System.out.println(ans);
    }
}