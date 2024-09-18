package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_삼오무 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int targetOrder;

    static boolean check(long targetSize) {
        long count = targetSize - (targetSize / 3) - (targetSize / 5) + (targetSize / 15);
        return count >= targetOrder;
    }

    static void sol() throws IOException {
        long left = 1, right = 2_000_000_000;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        targetOrder = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
