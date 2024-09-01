package lim.set;

import java.util.*;
import java.io.*;

public class HashSet_C_TAG {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static String[] aWords, bWords;

    static boolean check(int idx1, int idx2, int idx3) {
        HashSet<String> subWords = new HashSet<>();
        for (String aWord : aWords) {
            String subWord = "" + aWord.charAt(idx1) + aWord.charAt(idx2) + aWord.charAt(idx3);
            subWords.add(subWord);
        }

        for (String bWord : bWords) {
            String subWord = "" + bWord.charAt(idx1) + bWord.charAt(idx2) + bWord.charAt(idx3);
            if (subWords.contains(subWord)) {
                return false;
            }
        }
        return true;
    }

    static void sol() throws IOException {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    if (check(i, j, k)) {
                        count++;
                    }
                }
            }
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        aWords = new String[n];
        bWords = new String[n];
        for (int i = 0; i < n; i++) {
            aWords[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            bWords[i] = br.readLine();
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}