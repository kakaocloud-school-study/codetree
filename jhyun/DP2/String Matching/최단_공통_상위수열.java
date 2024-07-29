import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    //문자가 같은 경우, 이전 문자까지의 LCS 길이에 1을 더합니다.
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    //문자가 다른 경우, 이전 단계의 최대 LCS 길이를 취합니다.
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // 두 문자열의 길이의 합에서 LCS의 길이만큼 뺀 값이 곧 상위수열 중 최단 길이가 됩니다.
        System.out.println(n + m - dp[n][m]);
    }
}