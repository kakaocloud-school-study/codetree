import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;

    static long L[] = new long[MAX_N];
    static long R[] = new long[MAX_N];
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String word = br.readLine();

        //L[i] = 0번부터 i번 문자 C의 개수
        L[0] = (word.charAt(0) == 'C' ? 1 : 0);
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] + (word.charAt(i) == 'C' ? 1 : 0);
        }

        //L[i] = i번부터 n-1번 문자 중 W의 개수
        R[n - 1] = (word.charAt(n - 1) == 'W' ? 1 : 0);
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] + (word.charAt(i) == 'W' ? 1 : 0);
        }

        //각 위치 i에 대해 word[i]가 O라면
        //i보다 왼쪽에 있는 C의 개수인 L[i-1] &
        //i보다 오른쪽에 있는 W의 개수인 R[i+1]의 곱이
        //i를 중심으로 하여 COW 조합을 만들어 내는 숫자
        for (int i = 1; i < n - 1; i++) {
            if (word.charAt(i) == 'O') {
                ans += L[i - 1] * R[i + 1];
            }
        }
        System.out.print(ans);
    }
}