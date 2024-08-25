/*
 * 재귀로 풀면 시간초과...
 */
package lim.비트마스크;

import java.util.*;
import java.io.*;

public class Bitmask_bit_겹치는_bit가_없는_세_수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] arr;

    static void sol() throws IOException {
        long answer = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] & arr[j]) != 0L) {
                    continue;
                }
                for (int k = j + 1; k < arr.length; k++) {
                    if (((arr[i] | arr[j]) & arr[k]) != 0L) {
                        continue;
                    }
                    answer = Math.max(answer, arr[i] + arr[j] + arr[k]);
                }
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Long[] tmp = new Long[n];
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tmp[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(tmp, Collections.reverseOrder());
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = tmp[i];
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
