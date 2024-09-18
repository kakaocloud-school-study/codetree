package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_최소_통과_시간 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;

    static boolean check(long timeLimit) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            long delay = arr[i];
            count += timeLimit / delay;
        }
        return count >= n;
    }

    static void sol() throws IOException {
        long left = 1, right = 100_000_000_000_000L;
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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
