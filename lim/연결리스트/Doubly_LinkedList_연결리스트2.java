package lim.연결리스트;

import java.util.*;
import java.io.*;

public class Doubly_LinkedList_연결리스트2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, q;
    static int[][] queries;
    static HashMap<Integer, Node> nodeByNum = new HashMap<>();

    static class Node {
        int num;
        Node prev, next;

        Node(int num) {
            this.num = num;
        }
    }

    static void sol() throws IOException {
        for (int[] query : queries) {
            int cmd = query[0];
            int val1 = query[1];
            int val2 = query[2];

            if (cmd == 1) {
                Node node = nodeByNum.get(val1);
                Node prev = node.prev;
                Node next = node.next;
                if (prev != null) {
                    prev.next = next;
                    node.prev = null;
                }
                if (next != null) {
                    next.prev = prev;
                    node.next = null;
                }
            } else if (cmd == 2) {
                Node node = nodeByNum.get(val1);
                Node nNode = nodeByNum.get(val2);

                if (node.prev != null) {
                    node.prev.next = nNode;
                }
                nNode.prev = node.prev;
                nNode.next = node;
                node.prev = nNode;
            } else if (cmd == 3) {
                Node node = nodeByNum.get(val1);
                Node nNode = nodeByNum.get(val2);

                if (node.next != null) {
                    node.next.prev = nNode;
                }
                nNode.next = node.next;
                nNode.prev = node;
                node.next = nNode;
            } else if (cmd == 4) {
                Node node = nodeByNum.get(val1);
                if (node.prev == null) {
                    bw.write("0 ");
                } else {
                    bw.write(node.prev.num + " ");
                }
                if (node.next == null) {
                    bw.write("0\n");
                } else {
                    bw.write(node.next.num + "\n");
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            Node node = nodeByNum.get(i);
            if (node.next == null) {
                bw.write("0 ");
            } else {
                bw.write(node.next.num + " ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n + 1; i++) {
            Node node = new Node(i);
            nodeByNum.put(i, node);
        }

        st = new StringTokenizer(br.readLine());
        q = Integer.parseInt(st.nextToken());

        queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
            if (queries[i][0] == 2 || queries[i][0] == 3) {
                queries[i][2] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}