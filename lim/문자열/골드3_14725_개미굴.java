/*
 * 트라이
 */
package lim.문자열;

import java.util.*;
import java.io.*;

public class 골드3_14725_개미굴 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static ArrayList<ArrayList<String>> routes = new ArrayList<>();
    static Node root = new Node();

    static class Node {
        TreeMap<String, Node> childByWord = new TreeMap<>();
    }

    static void insert(ArrayList<String> route) {
        Node node = root;
        for (String word : route) {
            node.childByWord.putIfAbsent(word, new Node());
            node = node.childByWord.get(word);
        }
    }

    static void dfs(Node node, String depth) throws IOException {
        for (Map.Entry<String, Node> e : node.childByWord.entrySet()) {
            String word = e.getKey();
            Node nextNode = e.getValue();
            bw.write(depth + word + "\n");
            dfs(nextNode, depth + "--");
        }
    }

    static void sol() throws IOException {
        for (ArrayList<String> route : routes) {
            insert(route);
        }
        dfs(root, "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            ArrayList<String> route = new ArrayList<>();
            routes.add(route);
            for (int j = 0; j < count; j++) {
                route.add(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}