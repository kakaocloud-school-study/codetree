/*
 * 링 배열에서의 투포인터
 */
package lim.투포인터;

import java.util.*;
import java.io.*;

public class 실버1_1522_문자열_교환 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] bins;

    static int getCurrSize(int sIdx, int eIdx) {
        return eIdx - sIdx + 1;
    }

    static void sol() throws IOException {
        int[] countAtBin = new int[2];
        for (int bin : bins) {
            countAtBin[bin]++;
        }

        int targetBin = countAtBin[0] < countAtBin[1] ? 0 : 1;
        int wndSize = Math.min(countAtBin[0], countAtBin[1]);
        int targetCount = 0;
        int maxCount = 0;

        int eIdx = 0;
        for (int i = 0; i < bins.length; i++) {
            while (getCurrSize(i, eIdx) <= wndSize) {
                if (bins[eIdx % bins.length] == targetBin) {
                    targetCount++;
                }
                eIdx++;
            }
            maxCount = Math.max(maxCount, targetCount);
            if (bins[i] == targetBin) {
                targetCount--;
            }
        }

        bw.write(wndSize - maxCount + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] chs = st.nextToken().toCharArray();
        bins = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            bins[i] = chs[i] - 'a';
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
