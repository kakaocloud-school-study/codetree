package lim.map;

import java.util.*;
import java.io.*;

public class TreeMap_비율_구하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String[] words;

    static void sol() throws IOException {
        TreeMap<String, Integer> countByWord = new TreeMap<>();

        for (String word : words) {
            countByWord.put(word, countByWord.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : countByWord.entrySet()) {
            String word = e.getKey();
            int count = e.getValue();
            float rate = ((float) Math.round((((float) count) / n) * 1000000)) / 10000;
            System.out.printf("%s %.4f\n", word, rate);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}