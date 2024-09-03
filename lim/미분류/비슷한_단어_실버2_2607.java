package lim.미분류;

import java.util.*;
import java.io.*;

public class 비슷한_단어_실버2_2607 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, upperBound;
    static int[][] words;

    static void sol() throws IOException {
        int count = 0;
        for (int i = 1; i < words.length; i++) {
            int originDiff = 0;
            int otherDiff = 0;
            for (int j = 0; j < words[0].length; j++) {
                if (words[0][j] > words[i][j]) {
                    originDiff += words[0][j] - words[i][j];
                }
                if (words[0][j] < words[i][j]) {
                    otherDiff += words[i][j] - words[0][j];
                }
            }
            if (originDiff < 2 && otherDiff < 2) {
                count++;
            }
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        words = new int[n][26];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            for (int j = 0; j < word.length(); j++) {
                int ch = word.charAt(j) - 'A';
                words[i][ch]++;
            }
        }

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}