package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_폭탄_떨구기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, bombCount;
    static int[] arr;

    static boolean check(int bombRange) {
        int usedCount = 1;
        int prevPos = arr[0] + bombRange;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= prevPos + bombRange) {
                continue;
            }
            prevPos = arr[i] + bombRange;
            usedCount++;
        }
        return usedCount <= bombCount;
    }

    static void sol() throws IOException {
        Arrays.sort(arr);
        int left = 0, right = 1_000_000_000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
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
        bombCount = Integer.parseInt(st.nextToken());
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
