package lim.트리;

import java.util.*;
import java.io.*;

public class 이진_트리와_탐색_트리_순회 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Node root;
    static HashMap<String, Node> nodeByValue = new HashMap<>();

    static class Node {
        String value;
        Node left, right;

        Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static void pre(Node node) throws IOException {
        if (node == null) {
            return;
        }
        bw.write(node.value);
        pre(node.left);
        pre(node.right);
    }

    static void in(Node node) throws IOException {
        if (node == null) {
            return;
        }
        in(node.left);
        bw.write(node.value);
        in(node.right);
    }

    static void post(Node node) throws IOException {
        if (node == null) {
            return;
        }
        post(node.left);
        post(node.right);
        bw.write(node.value);
    }

    static void sol() throws IOException {
        pre(root);
        bw.write("\n");
        in(root);
        bw.write("\n");
        post(root);
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            String leftValue = st.nextToken();
            String rightValue = st.nextToken();
            Node left = null;
            Node right = null;
            if (!leftValue.equals(".")) {
                left = nodeByValue.getOrDefault(leftValue, new Node(leftValue, null, null));
                nodeByValue.put(leftValue, left);
            }
            if (!rightValue.equals(".")) {
                right = nodeByValue.getOrDefault(rightValue, new Node(rightValue, null, null));
                nodeByValue.put(rightValue, right);
            }
            Node node = nodeByValue.getOrDefault(value, new Node(value, left, right));
            node.left = left;
            node.right = right;
            nodeByValue.put(value, node);
            if (i == 0) {
                root = node;
            }
        }
        sol();
        br.close();
    }
}
