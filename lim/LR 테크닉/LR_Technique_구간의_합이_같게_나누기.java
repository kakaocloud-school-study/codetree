
/*
 * 쿼터*2 값이 되는 지점을 절반 후보지로 정함
 * 좌우에 각각 쿼터, 쿼터*3을 카운트하고
 * 절반 후보지 각각마다 좌우곱을 합산해 경우의 수 구함 
 */
import java.util.*;
import java.io.*;

public class LR_Technique_구간의_합이_같게_나누기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long[] leftCounts, rightCounts, arr, presum;

    static void sol() throws IOException {
        for (int i = 0; i < arr.length; i++) {
            presum[i] = arr[i];
            if (i > 0) {
                presum[i] += presum[i - 1];
            }
        }
        if (presum[presum.length - 1] % 4 != 0) {
            bw.write("0");
            return;
        }
        long quarter = presum[presum.length - 1] / 4;

        for (int i = 0; i < n; i++) {
            leftCounts[i] = 0;
            if (presum[i] == quarter) {
                leftCounts[i] = 1;
            }
            if (i > 0) {
                leftCounts[i] += leftCounts[i - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            rightCounts[i] = 0;
            if (presum[i] == quarter * 3) {
                rightCounts[i] = 1;
            }
            if (i < n - 1) {
                rightCounts[i] += rightCounts[i + 1];
            }
        }

        long answer = 0;
        for (int i = 1; i < n - 2; i++) {
            if (presum[i] == quarter * 2) {
                answer += leftCounts[i - 1] * rightCounts[i + 1];
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        leftCounts = new long[n];
        rightCounts = new long[n];
        arr = new long[n];
        presum = new long[n];
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
