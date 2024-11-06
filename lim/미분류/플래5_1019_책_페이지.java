/*
 * 다시 풀기
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 플래5_1019_책_페이지 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word;

    static void sol() throws IOException {
        long[] counts = new long[10];
        long n = Long.parseLong(word);
        long pos = 1;
        for (int i = word.length() - 1; i >= 0; i--) {
            int numAtPos = word.charAt(i) - '0';
            long prefix = n / (pos * 10);

            counts[0] -= pos; // ?
            for (int num = 0; num < numAtPos; num++) {
                counts[num] += (prefix + 1) * pos;
            }
            for (int num = numAtPos + 1; num < 10; num++) {
                counts[num] += prefix * pos;
            }
            counts[numAtPos] += prefix * pos + ((n % pos) + 1);
            pos *= 10;
        }
        for (int i = 0; i < counts.length; i++) {
            bw.write(counts[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        word = st.nextToken();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}