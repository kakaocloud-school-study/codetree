package lim.문자열;

import java.util.*;
import java.io.*;

public class Trie_트리_파악하기2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] words;
    static Node root = new Node(false);

    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;

        Node(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }

    static void insertWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'A';
            if (node.children[ch] == null) {
                node.children[ch] = new Node(false);
            }
            node = node.children[ch];
        }
        node.isEnd = true;
    }

    static void dfs(Node node, String depth) throws IOException {
        for (int i = 0; i < node.children.length; i++) {
            Node child = node.children[i];
            if (child == null) {
                continue;
            }
            char ch = (char) ('A' + i);
            bw.write(depth + ch + "\n");
            dfs(child, depth + "--");
        }
    }

    static void sol() throws IOException {
        for (String word : words) {
            insertWord(word);
        }
        dfs(root, "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        words = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int wordLen = Integer.parseInt(st.nextToken());
            String word = "";
            for (int j = 0; j < wordLen; j++) {
                word += st.nextToken();
            }
            words[i] = word;
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
