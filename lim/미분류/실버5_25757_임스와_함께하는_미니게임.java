package lim.미분류;

import java.util.*;
import java.io.*;

public class 실버5_25757_임스와_함께하는_미니게임 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int limit;
    static String[] words;

    static void sol() throws IOException {
        HashSet<String> names = new HashSet<>();
        for (String word : words) {
            names.add(word);
        }
        bw.write(names.size() / limit + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();
        if (gameType.equals("Y")) {
            limit = 1;
        } else if (gameType.equals("F")) {
            limit = 2;
        } else {
            limit = 3;
        }
        words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}