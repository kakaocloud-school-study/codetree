import java.util.*;
import java.io.*;

public class LR_Technique_마라톤_중간에_택시타기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] leftPresum, rightPresum;
    static int[][] points;

    static int getDist(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    static void sol() throws IOException {
        for (int i = 1; i < n; i++) {
            leftPresum[i] = leftPresum[i - 1] + getDist(points[i], points[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightPresum[i] = rightPresum[i + 1] + getDist(points[i], points[i + 1]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            answer = Math.min(answer, leftPresum[i - 1] + rightPresum[i + 1] + getDist(points[i - 1], points[i + 1]));
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        leftPresum = new int[n];
        rightPresum = new int[n];
        points = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
