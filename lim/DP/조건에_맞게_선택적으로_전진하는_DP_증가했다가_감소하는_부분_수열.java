/*
 * 해설이랑 좀 다르게 품. 시간은 동일
 * LR 테크닉을 응용
 * L방향 증가 수열 DP를 구하고 R방향에 대해서도 구했음
 * 특정 인덱스에 대해 좌우 dp합 - 1 하면 증가감소 수열 길이가 구해짐
 */
package lim.DP;

import java.util.*;
import java.io.*;

public class 조건에_맞게_선택적으로_전진하는_DP_증가했다가_감소하는_부분_수열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] leftDp, rightDp, arr;

    static void sol() throws IOException {
        for (int i = 0; i < leftDp.length; i++) {
            leftDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) {
                    continue;
                }
                leftDp[i] = Math.max(leftDp[i], leftDp[j] + 1);
            }
        }
        for (int i = rightDp.length - 1; i >= 0; i--) {
            rightDp[i] = 1;
            for (int j = rightDp.length - 1; j > i; j--) {
                if (arr[j] >= arr[i]) {
                    continue;
                }
                rightDp[i] = Math.max(rightDp[i], rightDp[j] + 1);
            }
        }

        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(answer, leftDp[i] + rightDp[i] - 1);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        leftDp = new int[n];
        rightDp = new int[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
