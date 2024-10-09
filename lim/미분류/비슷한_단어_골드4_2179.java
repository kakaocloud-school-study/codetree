/*
 * Trie를 이용하여 풀이
 * 먼저 나온 단어들은 트라이에 넣어 접두사 일치여부를 빠르게 알 수 있게 함
 * 최대 길이를 갱신해가는데 만약 길이가 같으면 단어쌍의 인덱스쌍이 사전순앞이 되도록 조건걸어서 갱신
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 비슷한_단어_골드4_2179 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String[] words;
    static Node root = new Node();
    static int maxLen = 0;
    static int aWordIdx, bWordIdx;

    static class Node {
        int endIdx = -1;
        Node[] children = new Node[26];
    }

    static void renewMax(int idx, String word) {
        Node node = root;
        int len = 0;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (node.children[ch] == null) {
                break;
            }
            node = node.children[ch];
            len++;
        }
        if (len < maxLen) {
            return;
        }
        while (node.endIdx == -1) {
            for (Node nextNode : node.children) {
                if (nextNode != null) {
                    node = nextNode;
                    break;
                }
            }
        }

        if (len == maxLen && node.endIdx >= aWordIdx) {
            return;
        }

        maxLen = len;
        aWordIdx = node.endIdx;
        bWordIdx = idx;
    }

    static void insert(int wordIdx, String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (node.children[ch] == null) {
                node.children[ch] = new Node();
            }
            node = node.children[ch];
        }
        node.endIdx = wordIdx;
    }

    static void sol() throws IOException {
        aWordIdx = 0;
        bWordIdx = 1;
        insert(0, words[0]);
        for (int i = 1; i < words.length; i++) {
            renewMax(i, words[i]);
            insert(i, words[i]);
        }
        bw.write(words[aWordIdx] + "\n" + words[bWordIdx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}