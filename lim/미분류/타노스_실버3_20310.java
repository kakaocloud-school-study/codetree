/*
그리디
 * 0이 가능한 앞에 오고 1이 가능한 뒤에 와야함
 * 지우는 문제이므로 0은 뒤에서부터 지우고
 * 1은 앞에서부터 지운다
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 타노스_실버3_20310 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String line;
    static boolean[] skipped;

    static void sol() throws IOException {
        int zeroCount = 0, oneCount = 0;
        for (char ch : line.toCharArray()) {
            if (ch == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        int oneSkippedCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (oneSkippedCount * 2 == oneCount) {
                break;
            }
            if (line.charAt(i) == '1') {
                skipped[i] = true;
                oneSkippedCount++;
            }
        }
        int zeroSkippedCount = 0;
        for (int i = line.length() - 1; i >= 0; i--) {
            if (zeroSkippedCount * 2 == zeroCount) {
                break;
            }
            if (line.charAt(i) == '0') {
                skipped[i] = true;
                zeroSkippedCount++;
            }
        }

        for (int i = 0; i < line.length(); i++) {
            if (skipped[i]) {
                continue;
            }
            bw.write(line.charAt(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        line = st.nextToken();
        skipped = new boolean[line.length()];
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}