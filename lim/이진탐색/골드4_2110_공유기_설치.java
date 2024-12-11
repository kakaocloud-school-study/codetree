package lim.이진탐색;

import java.util.*;
import java.io.*;

public class 골드4_2110_공유기_설치 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int goalCount;

    static boolean check(int minRange) {
        int count = 1;
        int prevAt = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < prevAt + minRange) {
                continue;
            }
            prevAt = arr[i];
            count++;
        }
        return count >= goalCount;
    }

    static void sol() throws IOException {
        Arrays.sort(arr);
        int lo = 0, hi = 1_000_000_000;
        int answer = lo;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(mid)) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        goalCount = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
