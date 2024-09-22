package lim.미분류;

import java.util.*;
import java.io.*;

public class 문자열_게임2_골드5_20437 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void sol(String word, int k) throws IOException {
        int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;

        for (char ch = 'a'; ch < 'z' + 1; ch++) {
            int count = 0;
            int eIdx = 0;
            for (int i = 0; i < word.length(); i++) {
                char sCh = word.charAt(i);
                if (sCh != ch) {
                    continue;
                }
                while (eIdx < word.length() && count < k) {
                    char eCh = word.charAt(eIdx);
                    if (eCh == ch) {
                        count++;
                    }
                    eIdx++;
                    if (count == k) {
                        minLen = Math.min(minLen, eIdx - i);
                        break;
                    }
                }
                count--;
            }
        }

        for (char ch = 'a'; ch < 'z' + 1; ch++) {
            int count = 0;
            int eIdx = 0;
            for (int i = 0; i < word.length(); i++) {
                char sCh = word.charAt(i);
                if (sCh != ch) {
                    continue;
                }
                while (eIdx < word.length()) {
                    char eCh = word.charAt(eIdx);
                    if (eCh == ch) {
                        count++;
                    }
                    eIdx++;
                    if (eCh == ch && count == k) {
                        maxLen = Math.max(maxLen, eIdx - i);
                        break;
                    }
                }
                count--;
            }
        }

        if (minLen == Integer.MAX_VALUE || maxLen == Integer.MIN_VALUE) {
            bw.write("-1\n");
            return;
        }
        bw.write(minLen + " " + maxLen + "\n");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            String word = br.readLine();
            int k = Integer.parseInt(br.readLine());
            sol(word, k);
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
