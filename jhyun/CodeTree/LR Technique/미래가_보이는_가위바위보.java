import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;

    static char[] matches = new char[MAX_N];

    static int[] L = new int[MAX_N];
    static int[] R = new int[MAX_N];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            matches[i] = br.readLine().charAt(0);
        }
        String shapes = new String("PHS");

        //L[i] = 0번부터 i번까지 동일한 모양만 냈을 때 최대로 이길 수 있는 횟수
        for (int s = 0; s < 3; s++) {
            char shape = shapes.charAt(s);
            int sameCnt = 0;
            for (int i = 0; i < n; i++) {
                if (matches[i] == shape) {
                    sameCnt++;
                }
                L[i] = Math.max(L[i], sameCnt);
            }
        }

        //R[i] = i번부터 n-1번까지 동일한 모양만 냈을 때 최대로 이길 수 있는 횟수
        for (int s = 0; s < 3; s++) {
            char shape = shapes.charAt(s);
            int sameCnt = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (matches[i] == shape) {
                    sameCnt++;
                }
                R[i] = Math.max(R[i], sameCnt);
            }
        }

        //해당 순간에 선택을 변경했다 했을 때 최대로 이기는 횟수를 갱신
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, L[i] + R[i + 1]);
        }

        System.out.print(ans);
    }
}