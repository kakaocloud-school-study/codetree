package lim.문자열;

import java.io.*;
import java.util.*;

public class 실버5_1181_단어_정렬 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<String> words = new ArrayList<>();

    static void sol() throws IOException {
        words = new ArrayList<>(new HashSet<>(words));
        Collections.sort(words, (w1, w2) -> {
            if (w1.length() == w2.length()) {
                return w1.compareTo(w2);
            }
            return w1.length() - w2.length();
        });
        bw.write(String.join("\n", words));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}