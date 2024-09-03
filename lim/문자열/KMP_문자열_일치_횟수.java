package lim.문자열;

import java.util.*;
import java.io.*;

public class KMP_문자열_일치_횟수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word, pattern;

    static int getCount() {
        int[] f = new int[pattern.length()];
        f[0] = -1;
        for (int i = 1; i < f.length; i++) {
            int j = f[i - 1];
            while (j >= 0 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = f[j];
            }
            f[i] = j + 1;
        }

        int j = 0;
        int count = 0;
        for (int i = 1; i < word.length(); i++) {
            while (j >= 0 && pattern.charAt(j + 1) != word.charAt(i)) {
                j = f[j];
            }
            j++;
            if (j == pattern.length() - 1) {
                count++;
                j = f[j];
            }
        }
        return count;
    }

    static void sol() throws IOException {
        bw.write(getCount() + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer.parseInt(st.nextToken());
        String tWord = br.readLine();
        String pWord = br.readLine();

        word = '#' + pWord.substring(1) + pWord;
        pattern = '#' + tWord;

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
