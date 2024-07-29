import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1000000007;

    static int n;
    static int[][] dp = new int[1005][15]; //i는 자릿수, j는 해당 자릿수에서의 숫자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }

        // 동적 프로그래밍을 사용하여 각 자리수마다 가능한 숫자들의 합을 계산
        // dp[i][j] :: i자릿수 까지 봤을 때, 마지막 숫자가 j인 가짓수
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= 9; j++){
                //숫자가 감소하는 경우
                if(j > 0){
                    dp[i+1][j-1] = (dp[i+1][j-1] + dp[i][j]) % MOD;
                }
                //숫자가 증가하는 경우
                if(j < 9){
                    dp[i+1][j+1] = (dp[i+1][j+1] + dp[i][j]) % MOD;
                }
            }
        }

        int ans = 0;
        for(int j = 0; j <= 9; j++){
            ans = (ans + dp[n][j]) % MOD;
        }

        System.out.println(ans);
    }
}