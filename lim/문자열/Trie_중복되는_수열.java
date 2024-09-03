package lim.문자열;

import java.util.*;
import java.io.*;

public class Trie_중복되는_수열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] words;
    static Node root = new Node(false);
    static int answer = 1;

    static class Node {
        Node[] children = new Node[10];
        boolean isEnd;

        Node(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }

    static void insertWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.isEnd) {
                answer = 0;
            }
            int ch = word.charAt(i) - '0';
            if (node.children[ch] == null) {
                node.children[ch] = new Node(false);
            }
            node = node.children[ch];
        }
        node.isEnd = true;
    }

    static void sol() throws IOException {
        for (String word : words) {
            insertWord(word);
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        Arrays.sort(words);

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
