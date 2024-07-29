import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int MAX_N = 100000;

    static int[] x = new int[MAX_N];
    static int[] y = new int[MAX_N];
    static int[] L = new int[MAX_N];
    static int[] R = new int[MAX_N];

    static int ans = INT_MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        L[0] = 0;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] + Math.abs(x[i] - x[i - 1]) + Math.abs(y[i] - y[i - 1]);
        }

        R[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] + Math.abs(x[i + 1] - x[i]) + Math.abs(y[i + 1] - y[i]);
        }

        //각 체크포인트마다 건너 뛰었다고 했을 때, 가능한 거리 합 중 최솟값
        for (int i = 1; i < n - 1; i++) {
            ans = Math.min(ans, L[i - 1] + R[i + 1] + Math.abs(x[i + 1] - x[i - 1]) + Math.abs(y[i + 1] - y[i - 1]));
        }
        System.out.print(ans);
    }
}