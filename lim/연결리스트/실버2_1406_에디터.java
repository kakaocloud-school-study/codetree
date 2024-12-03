package lim.연결리스트;

import java.util.*;
import java.io.*;

public class 실버2_1406_에디터 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word;
    static char[][] queries;

    static class Node {
        char ch;
        Node left, right;

        Node(char ch) {
            this.ch = ch;
        }

        void removeLeft() {
            if (left == null) {
                return;
            }
            Node newLeft = left.left;
            if (newLeft != null) {
                newLeft.right = this;
            }
            left = newLeft;
        }

        void addLeft(Node newLeft) {
            if (left != null) {
                left.right = newLeft;
            }
            newLeft.left = left;
            newLeft.right = this;
            left = newLeft;
        }
    }

    static void sol() throws IOException {
        Node cur = new Node('\n');
        for (char ch : word.toCharArray()) {
            cur.addLeft(new Node(ch));
        }

        for (char[] query : queries) {
            if (query[0] == 'L') {
                if (cur.left != null) {
                    cur = cur.left;
                }
            } else if (query[0] == 'D') {
                if (cur.right != null) {
                    cur = cur.right;
                }
            } else if (query[0] == 'B') {
                cur.removeLeft();
            } else if (query[0] == 'P') {
                cur.addLeft(new Node(query[1]));
            }
        }

        while (cur.left != null) {
            cur = cur.left;
        }

        while (cur.right != null) {
            bw.write(cur.ch);
            cur = cur.right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        word = st.nextToken();
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        queries = new char[q][2];
        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = st.nextToken().charAt(0);
            if (st.hasMoreTokens()) {
                queries[i][1] = st.nextToken().charAt(0);
            }
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
