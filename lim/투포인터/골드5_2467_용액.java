package lim.투포인터;

import java.util.*;
import java.io.*;

public class 골드5_2467_용액 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long[] arr;

    static void sol() throws IOException {
        long valueMin = Math.abs(arr[0] + arr[arr.length - 1]);
        int[] rangeWhenMin = { 0, arr.length - 1 };
        int eIdx = arr.length - 1;
        for (int sIdx = 0; sIdx < arr.length; sIdx++) {
            while (sIdx < eIdx && arr[sIdx] + arr[eIdx] >= 0) {
                long valueSum = Math.abs(arr[sIdx] + arr[eIdx]);
                if (valueMin > valueSum) {
                    valueMin = valueSum;
                    rangeWhenMin[0] = sIdx;
                    rangeWhenMin[1] = eIdx;
                }
                eIdx--;
            }
            if (sIdx < eIdx && valueMin > Math.abs(arr[sIdx] + arr[eIdx])) {
                valueMin = Math.abs(arr[sIdx] + arr[eIdx]);
                rangeWhenMin[0] = sIdx;
                rangeWhenMin[1] = eIdx;
            }
        }

        bw.write(arr[rangeWhenMin[0]] + " " + arr[rangeWhenMin[1]]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}