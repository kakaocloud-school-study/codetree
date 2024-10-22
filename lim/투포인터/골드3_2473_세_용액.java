package lim.투포인터;

import java.util.*;
import java.io.*;

public class 골드3_2473_세_용액 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long[] arr;

    static int[] getRangeWhenMin(int selectedIdx) {
        long offset = arr[selectedIdx];
        long valueMin = Long.MAX_VALUE;
        int[] rangeWhenMin = { -1, -1 };
        int eIdx = arr.length - 1 == selectedIdx ? arr.length - 2 : arr.length - 1;
        for (int sIdx = 0; sIdx < arr.length; sIdx++) {
            if (sIdx == selectedIdx) {
                continue;
            }
            while (sIdx < eIdx && arr[sIdx] + arr[eIdx] + offset >= 0) {
                long valueSum = Math.abs(arr[sIdx] + arr[eIdx] + offset);
                if (valueMin > valueSum) {
                    valueMin = valueSum;
                    rangeWhenMin[0] = sIdx;
                    rangeWhenMin[1] = eIdx;
                }
                eIdx--;
                if (eIdx == selectedIdx) {
                    eIdx--;
                }
            }
            if (sIdx < eIdx && valueMin > Math.abs(arr[sIdx] + arr[eIdx] + offset)) {
                valueMin = Math.abs(arr[sIdx] + arr[eIdx] + offset);
                rangeWhenMin[0] = sIdx;
                rangeWhenMin[1] = eIdx;
            }
        }
        return rangeWhenMin;
    }

    static void sol() throws IOException {
        long valueMin = Long.MAX_VALUE;
        int[] idxs = { -1, -1, -1 };

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int[] range = getRangeWhenMin(i);
            long valueSum = Math.abs(arr[i] + arr[range[0]] + arr[range[1]]);
            if (valueSum < valueMin) {
                valueMin = valueSum;
                idxs[0] = range[0];
                idxs[1] = range[1];
                idxs[2] = i;
            }
        }

        long[] values = { arr[idxs[0]], arr[idxs[1]], arr[idxs[2]] };
        Arrays.sort(values);
        bw.write(values[0] + " " + values[1] + " " + values[2]);
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