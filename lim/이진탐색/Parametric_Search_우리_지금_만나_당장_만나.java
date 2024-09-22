package lim.이진탐색;

/*
 * 실수형 이진탐색을 다시 복습해야
 * 너무 지저분하게 풀었다
 */
import java.util.*;
import java.io.*;

public class Parametric_Search_우리_지금_만나_당장_만나 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long[] positions, speeds;

    static boolean overlap(double s, double e, double s2, double e2) {
        return s <= e2 && s2 <= e;
    }

    static boolean check(double timeoutX1_000_000) {
        double s = positions[0] - timeoutX1_000_000 / 1_000_000 * speeds[0];
        double e = positions[0] + timeoutX1_000_000 / 1_000_000 * speeds[0];
        for (int i = 1; i < positions.length; i++) {
            double s2 = positions[i] - timeoutX1_000_000 / 1_000_000 * speeds[i];
            double e2 = positions[i] + timeoutX1_000_000 / 1_000_000 * speeds[i];
            if (!overlap(s, e, s2, e2)) {
                return false;
            }
            s = Math.max(s, s2);
            e = Math.min(e, e2);
        }
        return true;
    }

    static void sol() throws IOException {
        long left = 0, right = 1_000_000_000 * 1_000_000L;
        double answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        answer = Math.floor(answer / 10);
        System.out.printf("%.4f", (answer / 100_000));
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        positions = new long[n];
        speeds = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < positions.length; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < positions.length; i++) {
            speeds[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
