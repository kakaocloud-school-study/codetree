/*
 * 코드트리 그리디 문제랑 비슷한데 첫칸도 뒤집을 수 있어서 경우의 수를 두경우로 나눠 품
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 전구와_스위치_골드4_2138 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] diffs1, diffs2;

    static void flip(int[] arr, int idx) {
        if (idx > 0) {
            arr[idx - 1] ^= 1;
        }
        arr[idx] ^= 1;
        if (idx + 1 < arr.length) {
            arr[idx + 1] ^= 1;
        }
    }

    static void sol() throws IOException {
        flip(diffs1, 0);

        int count1 = 1;
        int count2 = 0;
        for (int i = 1; i < diffs1.length; i++) {
            if (diffs1[i - 1] == 1) {
                flip(diffs1, i);
                count1++;
            }
            if (diffs2[i - 1] == 1) {
                flip(diffs2, i);
                count2++;
            }
        }

        int minCount = Integer.MAX_VALUE;
        if (diffs1[n - 1] == 0 && count1 < minCount) {
            minCount = count1;
        }
        if (diffs2[n - 1] == 0 && count2 < minCount) {
            minCount = count2;
        }
        if (minCount == Integer.MAX_VALUE) {
            minCount = -1;
        }

        bw.write(minCount + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String[] src = st.nextToken().split("");

        st = new StringTokenizer(br.readLine());
        String[] dest = st.nextToken().split("");

        diffs1 = new int[n];
        diffs2 = new int[n];
        for (int i = 0; i < n; i++) {
            diffs1[i] = 1;
            diffs2[i] = 1;
            if (src[i].equals(dest[i])) {
                diffs1[i] = 0;
                diffs2[i] = 0;
            }
        }

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}