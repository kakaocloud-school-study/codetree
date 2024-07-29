import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_LEN = 1000;

    static String str1, str2;
    static int[][] dp = new int[MAX_LEN + 1][MAX_LEN + 1];

    static int str1Len, str2Len;

    static void init(){
        // dp[1][1] 값은 첫 번째 문자열의 첫 번째 문자와 두 번째 문자열의 첫 번째 문자가 같은지 여부를 저장
        dp[1][1] = str1.charAt(1) == str2.charAt(1) ? 1 : 0;

        // 두 번째 문자열의 1번 인덱스의 문자까지만 사용했을 때 가능한 부분 수열의 최대 길이를 채워넣어줍니다.
        for(int i =2; i <= str1Len; i++){
            if(str1.charAt(i) == str2.charAt(1)){
                dp[i][1] = 1;
            }else{
                dp[i][1] = dp[i-1][1];
            }
        }

        // 첫 번째 문자열의 1번 인덱스의 문자까지만 사용했을 때 가능한 부분 수열의 최대 길이를 채워넣어줍니다.
        for(int j = 2; j <= str2Len; j++){
            if(str1.charAt(1) == str2.charAt(j)){
                dp[1][j] = 1;
            }else {
                dp[1][j] = dp[1][j-1];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        str1Len = str1.length();
        str2Len = str2.length();

        // string의 index가 0부터 시작하기 때문에 이를 1부터 시작하기 위해서 앞에 # 추가
        str1 = "#" + str1;
        str2 = "#" + str2;

        init();

        for(int i = 2; i <= str1Len; i++) {
            //첫 번째 문자열의 i 번째까지 문자열을 고려했고 두 변째 문자열의 j 번째까지 문자열을 고려했을 때
            //가능한 부분 수열의 최대 길이 구하기
            for(int j = 2; j <= str2Len; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[str1Len][str2Len]);
    }
}