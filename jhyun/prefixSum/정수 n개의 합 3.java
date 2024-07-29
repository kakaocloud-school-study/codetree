import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 500;
    static final int[][] arr = new int[MAX_N + 1][MAX_N + 1];
    static final int[][] prefixSum = new int[MAX_N + 1][MAX_N + 1];
    static int maxSum = Integer.MIN_VALUE;

    public static int getSum(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        prefixSum[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i][j];
            }
        }

        for (int i = 1; i <= n - k + 1; i++) {
            for (int j = 1; j <= n - k + 1; j++) {
                maxSum = Math.max(maxSum, getSum(i, j, i + k - 1, j + k - 1));
            }
        }

        System.out.print(maxSum);
    }
}