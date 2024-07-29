import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int m = b.length();
        int[][] dp = new int[1005][1005];

        for(int i = 1; i <=n; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= m; j++){
            dp[0][j] = j;
        }

        //두 문자열의 각 문자를 비교하면 dp 완성
        //dp[i][j] :: a문자열의 처음 i개 문자열을, b문자열의 처음 j개로 바꾸는데 필요한 최소 연산 횟수
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    //문자가 같으면 이전 편집 거리를 가져옴
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    //문자가 다르면 문자를 삽입 or 삭제
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}