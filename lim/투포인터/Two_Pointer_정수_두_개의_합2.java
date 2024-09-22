package lim.투포인터;

import java.util.*;
import java.io.*;

public class Two_Pointer_정수_두_개의_합2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static int[] arr;

    static void sol() throws IOException {
        Arrays.sort(arr);

        int answer = 0;
        int eIdx = arr.length - 1;
        for (int sIdx = 0; sIdx < arr.length; sIdx++) {
            while (sIdx < eIdx && arr[sIdx] + arr[eIdx] > k) {
                eIdx--;
            }
            if (sIdx < eIdx && arr[sIdx] + arr[eIdx] <= k) {
                answer += eIdx - sIdx;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
