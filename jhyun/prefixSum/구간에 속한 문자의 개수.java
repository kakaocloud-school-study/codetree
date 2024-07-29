import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_NUM = 1000;
    static final int MAX_C = 3;

    static int[][] arr = new int[MAX_NUM + 1][MAX_NUM + 1];
    static int[][][] prefixSum = new int[MAX_C + 1][MAX_NUM + 1][MAX_NUM + 1];

    // (x1, y1), (x2, y2) 직사각형 구간 내의 원소의 합을 반환합니다.
    static int getSum(int c, int x1, int y1, int x2, int y2) {
        return prefixSum[c][x2][y2] - prefixSum[c][x1 - 1][y2] - prefixSum[c][x2][y1 - 1] + prefixSum[c][x1 - 1][y1
                - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 1; j <= m; j++) {
                char c = input.charAt(j - 1);

                // 편의를 위해 a, b, c를 1, 2, 3으로 저장
                if (c == 'a') {
                    arr[i][j] = 1;
                } else if (c == 'b') {
                    arr[i][j] = 2;
                } else {
                    arr[i][j] = 3;
                }
            }
        }

        // prefixSum[c][i][j] : 숫자가 c인 경우에 대한 누적합을 저장
        for (int c = 1; c <= 3; c++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int additionalValue = 0;

                    // (i, j) 위치에 적혀있는 숫자가 c인 경우에만 1 증가
                    if (arr[i][j] == c) {
                        additionalValue = 1;
                    }
                    prefixSum[c][i][j] = prefixSum[c][i - 1][j] + prefixSum[c][i][j - 1] - prefixSum[c][i - 1][j - 1]
                            + additionalValue;
                }
            }
        }

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.print(getSum(1, x1, y1, x2, y2) + " "); //a
            System.out.print(getSum(2, x1, y1, x2, y2) + " "); //b
            System.out.println(getSum(3, x1, y1, x2, y2)); //c
        }
    }
}