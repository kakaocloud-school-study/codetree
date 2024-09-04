package lim.연결리스트;

import java.util.*;
import java.io.*;

public class Doubly_LinkedList_강강수월래 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, q;
    static int[][] queries;
    static HashMap<Integer, Node> nodeByNum = new HashMap<>();

    static class Node {
        int num;
        Node prev, next;

        Node(int num) {
            this.num = num;
        }
    }

    static Node findMinNode(Node startNode) {
        Node node = startNode.next;
        Node minNode = startNode;
        while (node.num != startNode.num) {
            if (node.num < minNode.num) {
                minNode = node;
            }
            node = node.next;
        }
        return minNode;
    }

    static void printCircle(Node startNode) throws IOException {
        bw.write(startNode.num + " ");
        Node node = startNode.prev;
        while (node.num != startNode.num) {
            bw.write(node.num + " ");
            node = node.prev;
        }
    }

    static void sol() throws IOException {
        for (int[] query : queries) {
            int cmd = query[0];
            int val1 = query[1];
            int val2 = query[2];

            if (cmd == 1) {
                Node aNode = nodeByNum.get(val1);
                Node bNode = nodeByNum.get(val2);
                Node aOldNext = aNode.next;
                Node bOldPrev = bNode.prev;

                aNode.next = bNode;
                bNode.prev = aNode;
                bOldPrev.next = aOldNext;
                aOldNext.prev = bOldPrev;
            } else if (cmd == 2) {
                Node aNode = nodeByNum.get(val1);
                Node bNode = nodeByNum.get(val2);
                Node aEndNode = bNode.prev;
                Node bEndNode = aNode.prev;

                aNode.prev = aEndNode;
                aEndNode.next = aNode;
                bNode.prev = bEndNode;
                bEndNode.next = bNode;
            } else if (cmd == 3) {
                Node node = nodeByNum.get(val1);
                node = findMinNode(node);
                printCircle(node);
            }
        }
    }

    static void makeCircle(int[] arr) {
        Node first = new Node(arr[0]);
        Node prev = first;
        nodeByNum.put(first.num, first);
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            nodeByNum.put(node.num, node);

            prev.next = node;
            node.prev = prev;
            prev = node;
        }
        first.prev = prev;
        prev.next = first;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int memberCount = Integer.parseInt(st.nextToken());
            int[] arr = new int[memberCount];
            for (int j = 0; j < memberCount; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            makeCircle(arr);
        }

        queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
            if (queries[i][0] == 1 || queries[i][0] == 2) {
                queries[i][2] = Integer.parseInt(st.nextToken());
            }
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}