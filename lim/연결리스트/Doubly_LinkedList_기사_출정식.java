package lim.연결리스트;

import java.util.*;
import java.io.*;

public class Doubly_LinkedList_기사_출정식 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, q;
    static int[] queries;
    static HashMap<Integer, Node> nodeByNum = new HashMap<>();

    static class Node {
        int num;
        Node prev, next;

        Node(int num) {
            this.num = num;
        }
    }

    static void sol() throws IOException {
        for (int query : queries) {
            Node node = nodeByNum.get(query);
            Node prev = node.prev;
            Node next = node.next;
            bw.write(next.num + " ");
            bw.write(prev.num + "\n");
            prev.next = next;
            next.prev = prev;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Node first = new Node(Integer.parseInt(st.nextToken()));
        Node prev = first;
        nodeByNum.put(first.num, first);
        for (int i = 0; i < n - 1; i++) {
            Node node = new Node(Integer.parseInt(st.nextToken()));
            nodeByNum.put(node.num, node);

            prev.next = node;
            node.prev = prev;
            prev = node;
        }
        first.prev = prev;
        prev.next = first;

        queries = new int[q];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}