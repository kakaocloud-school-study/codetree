import java.util.*;
import java.io.*;

public class LR_Technique_인접하지_않은_3개의_숫자 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] leftMaxNums, rightMaxNums, arr;

    static int getDist(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    static void sol() throws IOException {
        for (int i = 0; i < n; i++) {
            leftMaxNums[i] = arr[i];
            if (i > 0) {
                leftMaxNums[i] = Math.max(leftMaxNums[i], leftMaxNums[i - 1]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            rightMaxNums[i] = arr[i];
            if (i < n - 1) {
                rightMaxNums[i] = Math.max(rightMaxNums[i], rightMaxNums[i + 1]);
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 2; i < n - 2; i++) {
            answer = Math.max(answer, leftMaxNums[i - 2] + rightMaxNums[i + 2] + arr[i]);
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        leftMaxNums = new int[n];
        rightMaxNums = new int[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
