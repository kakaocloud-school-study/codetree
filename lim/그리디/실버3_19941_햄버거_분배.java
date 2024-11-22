package lim.그리디;

import java.util.*;
import java.io.*;

public class 실버3_19941_햄버거_분배 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, range;
    static String word;

    static void sol() throws IOException {
        int count = 0;
        boolean[] used = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'H') {
                continue;
            }

            for (int j = Math.max(0, i - range); j <= Math.min(word.length() - 1, i + range); j++) {
                if (word.charAt(j) == 'P' || used[j]) {
                    continue;
                }
                used[j] = true;
                count++;
                break;
            }
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        word = br.readLine();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}