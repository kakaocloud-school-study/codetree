package lim.문자열;

import java.util.*;
import java.io.*;

public class Trie_xor_중_최대 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] words;
    static Node root = new Node(false);
    static int n;

    static class Node {
        Node[] children = new Node[2];
        boolean isEnd;

        Node(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }

    static void insertWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - '0';
            if (node.children[ch] == null) {
                node.children[ch] = new Node(false);
            }
            node = node.children[ch];
        }
        node.isEnd = true;
    }

    static int getMaxXor(String word) {
        int maxXor = 0;
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            int digit = word.charAt(i) - '0';
            Node bestChild = node.children[digit ^ 1];
            Node otherChild = node.children[digit];
            if (bestChild != null) {
                node = bestChild;
                maxXor += 1 << (word.length() - 1 - i);
                continue;
            }
            node = otherChild;
        }
        return maxXor;
    }

    static void sol() throws IOException {
        for (String word : words) {
            insertWord(word);
        }
        int answer = 0;
        for (String word : words) {
            answer = Math.max(answer, getMaxXor(word));
        }
        bw.write(answer + "");
    }

    static String toBinStr(int num) {
        StringBuilder bin = new StringBuilder("");
        while (num > 0) {
            bin.append(num % 2);
            num /= 2;
        }
        while (bin.length() < 31) {
            bin.append("0");
        }
        bin.reverse();
        return bin.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        words = new String[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            words[i] = toBinStr(num);
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
