package lim.미분류;

import java.util.*;
import java.io.*;

public class 영단어_암기는_괴로워_실버3_20920 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, limit;
    static HashMap<String, Integer> countByWord = new HashMap<>();
    static String[] words;

    static void sol() throws IOException {
        Arrays.sort(words, (w1, w2) -> {
            int count1 = countByWord.get(w1);
            int count2 = countByWord.get(w2);
            if (count1 == count2) {
                if (w1.length() == w2.length()) {
                    return w1.compareTo(w2);
                }
                return w2.length() - w1.length();
            }
            return count2 - count1;
        });
        for (int i = 0; i < words.length; i++) {
            bw.write(words[i] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < limit) {
                continue;
            }
            int count = countByWord.getOrDefault(word, 0);
            countByWord.put(word, count + 1);
        }
        words = new String[countByWord.size()];
        int idx = 0;
        for (String word : countByWord.keySet()) {
            words[idx++] = word;
        }
        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}