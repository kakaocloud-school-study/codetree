package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_정수_분배하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, targetCount;
    static int[] arr;

    static boolean check(int targetSize) {
        int count = 0;
        for (int num : arr) {
            count += num / targetSize;
        }
        return count >= targetCount;
    }

    static void sol() throws IOException {
        int left = 1, right = 10_000;
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
        targetCount = Integer.parseInt(st.nextToken());
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
