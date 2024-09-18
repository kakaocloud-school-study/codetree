package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_최대_거리의_점 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;

    static boolean check(int minDist) {
        int count = 1;
        int prevPos = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prevPos >= minDist) {
                prevPos = arr[i];
                count++;
            }
        }
        return count >= m;
    }

    static void sol() throws IOException {
        Arrays.sort(arr);
        int left = 1, right = 1_000_000_000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
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
