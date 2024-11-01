/*
 * 맵, 투포인터, 이진탐색 등등 풀이는 많지만 모종의 자료구조를 사용하는 순간 이론과는 다르게 시간초과가 남
 * 일체의 자료구조를 배제하고 배열만 사용해야 함. ArrayList도 마찬가지로 못 씀. 또한 경우의 수는 long을 사용.
 * 합 0이 되는 순간까지 움직이는 투포인터를 구현하고 그 시점으로 부터 0을 만드는 좌우 값을 탐색해 좌우곱을 카운트하는 방식으로 풀이 
 */
package lim.투포인터;

import java.util.*;
import java.io.*;

public class 골드2_7453_합이_0인_네_정수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] arrs;

    static void sol() throws IOException {
        int[] abSums = new int[n * n];
        int[] cdSums = new int[n * n];

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length; j++) {
                abSums[i * n + j] = arrs[i][0] + arrs[j][1];
                cdSums[i * n + j] = arrs[i][2] + arrs[j][3];
            }
        }

        Arrays.sort(abSums);
        Arrays.sort(cdSums);

        long count = 0;
        int sIdx = 0;
        int eIdx = cdSums.length - 1;
        while (sIdx < abSums.length) {
            while (0 <= eIdx && abSums[sIdx] + cdSums[eIdx] > 0) {
                eIdx--;
            }
            if (0 <= eIdx && abSums[sIdx] + cdSums[eIdx] == 0) {
                long leftCount = 1;
                long rightCount = 1;
                while (sIdx + 1 < abSums.length && abSums[sIdx] == abSums[sIdx + 1]) {
                    leftCount++;
                    sIdx++;
                }
                while (0 <= eIdx - 1 && cdSums[eIdx] == cdSums[eIdx - 1]) {
                    rightCount++;
                    eIdx--;
                }
                count += leftCount * rightCount;
            }
            sIdx++;
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arrs = new int[n][4];
        for (int i = 0; i < arrs.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arrs[0].length; j++) {
                arrs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}