package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_자연수_n개의_합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long upperBoundSum;

    static boolean check(long num) {
        return num * (num + 1) / 2 <= upperBoundSum;
    }

    static void sol() throws IOException {
        long left = 0, right = (long) Math.sqrt(upperBoundSum * 2);
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        upperBoundSum = Long.parseLong(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
