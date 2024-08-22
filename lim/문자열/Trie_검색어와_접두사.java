package lim.문자열;

import java.util.*;
import java.io.*;

public class Trie_검색어와_접두사 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] words;
    static String keyword;
    static Node root = new Node(false);
    static int n, m;
    static int[] dp;

    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
        int id;
        static int nextId = 0;

        Node(boolean isEnd) {
            this.isEnd = isEnd;
            this.id = nextId++;
        }
    }

    static void insertWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (node.children[ch] == null) {
                node.children[ch] = new Node(false);
            }
            node = node.children[ch];
        }
        node.isEnd = true;
    }

    static int dfs(Node node) {
        int count = 0;
        if (node.isEnd) {
            count++;
        }
        for (int i = 0; i < node.children.length; i++) {
            Node child = node.children[i];
            if (child == null) {
                continue;
            }
            count += dfs(child);
        }
        dp[node.id] = count;
        return count;
    }

    static void sol() throws IOException {
        for (String word : words) {
            insertWord(word);
        }
        dp = new int[Node.nextId];
        dfs(root);

        Node node = root;
        for (int i = 0; i < keyword.length(); i++) {
            if (node == null) {
                bw.write("0 ");
                continue;
            }

            int ch = keyword.charAt(i) - 'a';
            Node child = node.children[ch];
            if (child != null) {
                bw.write(dp[child.id] + " ");
            } else {
                bw.write("0 ");
            }
            node = child;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = st.nextToken();
        }
        keyword = br.readLine();

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
