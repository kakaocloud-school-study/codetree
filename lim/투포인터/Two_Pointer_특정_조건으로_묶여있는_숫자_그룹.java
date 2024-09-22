package lim.투포인터;

/*
 * 포인터를 4개 만들어서 풀었음
 * 해설에서는 LR테크닉 응용함
 */
import java.util.*;
import java.io.*;

public class Two_Pointer_특정_조건으로_묶여있는_숫자_그룹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static int[] arr;

    static void sol() throws IOException {
        Arrays.sort(arr);

        int answer = 0;
        int eIdx = 0;
        for (int sIdx = 0; sIdx < arr.length; sIdx++) {
            int len1 = 0, len2 = 0;
            eIdx = Math.max(eIdx, sIdx + 1);
            while (sIdx < eIdx && eIdx < arr.length && Math.abs(arr[sIdx] - arr[eIdx]) <= k) {
                len1 = eIdx - sIdx + 1;
                eIdx++;
            }
            int eIdx2 = eIdx;
            for (int sIdx2 = eIdx; sIdx2 < arr.length; sIdx2++) {
                eIdx2 = Math.max(eIdx2, sIdx2 + 1);
                while (sIdx2 < eIdx2 && eIdx2 < arr.length && Math.abs(arr[sIdx2] - arr[eIdx2]) <= k) {
                    len2 = eIdx2 - sIdx2 + 1;
                    eIdx2++;
                }
                if (len1 != 0 && len2 != 0) {
                    answer = Math.max(answer, len1 + len2);
                }
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
