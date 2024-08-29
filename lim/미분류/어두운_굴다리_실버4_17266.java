package lim.미분류;

import java.util.*;
import java.io.*;

public class 어두운_굴다리_실버4_17266 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, lightCount;
    static int[] arr;

    static boolean check(int height) {
        int sIdx = arr[0] - height;
        int eIdx = arr[0] + height;
        if (sIdx > 0) {
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            int nSIdx = arr[i] - height;
            int nEIdx = arr[i] + height;
            if (eIdx < nSIdx) {
                return false;
            }
            eIdx = nEIdx;
        }
        return eIdx >= n;
    }

    static void sol() throws IOException {
        int left = 0, right = n, answer = n;

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        lightCount = Integer.parseInt(st.nextToken());
        arr = new int[lightCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lightCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}