import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 200001;

    static String temp;
    static char[] inputStr = new char[MAX_N];
    static int n;

    static int[] A = new int[MAX_N];
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();
        int len = temp.length();

        // Manacher's algorithm을 적용하기 위해
        // 주어진 문자열 내 문자 사이사이에 #을 넣어줍니다.
        for(int i = 0; i < len; i++){
            inputStr[i * 2] = '#';
            inputStr[i * 2 + 1] = temp.charAt(i);
        }

        n = len * 2 + 1;
        inputStr[n - 1] = '#';

        // r : j < i를 만족하는 j들 중 Math.max(j + A[j]) 값을 기록합니다.
        // p : Math.max(j + A[j]) 가 되는 j의 값을 기록합니다.
        int r = -1;
        int p = -1;

        for(int i = 0; i < n; i++) {
            if(r < i){
                A[i] = 0;
            }else{
                int ii = 2 * p - i;
                A[i] = Math.min(r - i, A[ii]);
            }

            while(i - A[i] - 1 >= 0 && i + A[i] + 1 < n && inputStr[i - A[i] - 1] == inputStr[i + A[i] + 1]){
                A[i]++;
            }

            // i + A[i] 중 최대가 선택되도록
            // r, p값을 갱신해줍니다.
            if(i + A[i] > r){
                r = i + A[i];
                p = i;
            }
        }

        for(int i = 0; i < n; i++) {
            int maxLen = 2 * A[i] + 1;
            int l = maxLen / 2;

            ans += (l + 1) / 2;
        }

        System.out.print(ans);
    }
}