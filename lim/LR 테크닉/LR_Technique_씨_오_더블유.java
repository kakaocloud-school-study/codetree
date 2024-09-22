import java.util.*;
import java.io.*;

public class LR_Technique_씨_오_더블유 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] leftCounts, rightCounts, arr;

    static int getDist(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    static void sol() throws IOException {
        for (int i = 0; i < n; i++) {
            leftCounts[i] = 0;
            if (arr[i] == 'C') {
                leftCounts[i] = 1;
            }
            if (i > 0) {
                leftCounts[i] += leftCounts[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            rightCounts[i] = 0;
            if (arr[i] == 'W') {
                rightCounts[i] = 1;
            }
            if (i < n - 1) {
                rightCounts[i] += rightCounts[i + 1];
            }
        }

        long answer = 0;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] == 'O') {
                answer += ((long) leftCounts[i - 1]) * ((long) rightCounts[i + 1]);
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        leftCounts = new int[n];
        rightCounts = new int[n];
        arr = new int[n];

        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = line.charAt(i);
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
