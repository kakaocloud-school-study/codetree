package lim.문자열;

import java.util.*;
import java.io.*;

public class 실버1_1283_단축키_지정 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] lines;

    static void sol() throws IOException {
        HashSet<Character> hotkeys = new HashSet<>();

        for (String line : lines) {
            boolean hasHotkey = false;
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (!hotkeys.contains(Character.toLowerCase(words[i].charAt(0))) && !hasHotkey) {
                    // String newWord = String.format("[%s]%s", word.charAt(0), word.substring(1,
                    // word.length()));
                    String newWord = words[i].replaceFirst(words[i].charAt(0) + "", "[" + words[i].charAt(0) + "]");
                    hotkeys.add(Character.toLowerCase(words[i].charAt(0)));
                    hasHotkey = true;
                    words[i] = newWord;
                }
            }

            if (hasHotkey) {
                bw.write(String.join(" ", words) + "\n");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : line.toCharArray()) {
                if (!hotkeys.contains(Character.toLowerCase(ch)) && ch != ' ' && !hasHotkey) {
                    sb.append("[" + ch + "]");
                    hotkeys.add(Character.toLowerCase(ch));
                    hasHotkey = true;
                } else {
                    sb.append(ch);
                }
            }
            bw.write(sb.toString() + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        lines = new String[n];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = br.readLine();
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
