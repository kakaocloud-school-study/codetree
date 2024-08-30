package lim.map;

import java.util.*;
import java.io.*;

public class HashMap_순서를_바꾸었을_때_같은_단어_그룹화하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String[] words;

    static void sol() throws IOException {
        HashMap<String, Integer> countByWord = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            words[i] = String.valueOf(chars);
        }
        for (String word : words) {
            countByWord.put(word, countByWord.getOrDefault(word, 0) + 1);
        }

        int answer = 0;
        for (Map.Entry<String, Integer> e : countByWord.entrySet()) {
            answer = Math.max(answer, e.getValue());
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        words = new String[n];
        for (int i = 0; i < words.length; i++) {
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}