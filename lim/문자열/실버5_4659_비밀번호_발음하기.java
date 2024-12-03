package lim.문자열;

import java.util.*;
import java.io.*;

public class 실버5_4659_비밀번호_발음하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<String> words = new ArrayList<>();

    static void sol() throws IOException {
        String vowels = "[a|e|i|o|u]";
        String consonents = "[b|c|d|f|g|h|j|k|l|m|n|p|q|r|s|t|v|w|x|y|z]";
        for (String word : words) {
            if (!word.matches(String.format(".*%s.*", vowels))) {
                bw.write(String.format("<%s> is not acceptable.\n", word));
            } else if (word.matches(String.format(".*%s{3,}.*", vowels)) || word
                    .matches(String.format(".*%s{3,}.*", consonents))) {
                bw.write(String.format("<%s> is not acceptable.\n", word));
            } else if (word.matches(".*([^(e|o)])\\1+.*")) {
                bw.write(String.format("<%s> is not acceptable.\n", word));
            } else {
                bw.write(String.format("<%s> is acceptable.\n", word));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String word = br.readLine();
            if (word.equals("end")) {
                break;
            }
            words.add(word);
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}