package lim.연결리스트;

import java.util.*;
import java.io.*;

public class Doubly_LinkedList_코드트리_유치원 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int q, nextNum = 1;
    static int[][] queries;
    static HashMap<Integer, Node> nodeByNum = new HashMap<>();

    static class Node {
        int num;
        Node prev, next;

        Node(int num) {
            this.num = num;
        }
    }

    static void insertPrev(Node target, Node newNode) {
        if (target.prev != null) {
            target.prev.next = newNode;
        }
        newNode.prev = target.prev;
        newNode.next = target;
        target.prev = newNode;
    }

    static void insertNext(Node target, Node newNode) {
        if (target.next != null) {
            target.next.prev = newNode;
        }
        newNode.next = target.next;
        newNode.prev = target;
        target.next = newNode;
    }

    static Node nextNode() {
        Node node = new Node(nextNum++);
        nodeByNum.put(node.num, node);
        return node;
    }

    static void sol() throws IOException {
        for (int[] query : queries) {
            int cmd = query[0];
            int val1 = query[1];
            int val2 = query[2];

            if (cmd == 1) {
                int count = val2;
                Node node = nodeByNum.get(val1);

                Node newNode = nextNode();
                insertNext(node, newNode);
                node = newNode;
                count--;

                while (count-- > 0) {
                    newNode = nextNode();
                    insertNext(node, newNode);
                    node = newNode;
                }
            } else if (cmd == 2) {
                int count = val2;
                Node node = nodeByNum.get(val1);

                Node newNode = nextNode();
                insertPrev(node, newNode);
                node = newNode;
                count--;

                while (count-- > 0) {
                    newNode = nextNode();
                    insertNext(node, newNode);
                    node = newNode;
                }
            } else if (cmd == 3) {
                Node node = nodeByNum.get(val1);
                if (node.prev == null || node.next == null) {
                    bw.write("-1\n");
                } else {
                    bw.write(node.prev.num + " ");
                    bw.write(node.next.num + "\n");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        q = Integer.parseInt(st.nextToken());

        queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
            if (queries[i][0] == 1 || queries[i][0] == 2) {
                queries[i][2] = Integer.parseInt(st.nextToken());
            }
        }

        nextNode();

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}