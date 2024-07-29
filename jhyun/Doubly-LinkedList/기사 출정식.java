import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_N = 100002;

    static class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    // 기사들 관리
    static Node[] nodes = new Node[MAX_N];

    // 기사들의 번호의 범위 1 ~ 10억이므로 map으로 기사 번호 관리
    static Map<Integer, Integer> nodeId = new HashMap<>();

    static void connect(Node s, Node e) {
        if (s != null) {
            s.next = e;
        }
        if (e != null) {
            e.prev = s;
        }
    }

    static void pop(Node u) {
        connect(u.prev, u.next);
        u.prev = u.next = null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int knightNum = Integer.parseInt(st.nextToken());
        nodeId.put(knightNum, 1);
        nodes[1] = new Node(knightNum);
        for (int i = 2; i <= n; i++) {
            knightNum = Integer.parseInt(st.nextToken());
            nodeId.put(knightNum, i);
            nodes[i] = new Node(knightNum);
            connect(nodes[i - 1], nodes[i]);

            // 원탁이기 때문에 연결 리스트가 원형으로 이어져 있음
            if (i == n) {
                connect(nodes[n], nodes[1]);
            }
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            knightNum = Integer.parseInt(st.nextToken());

            System.out.println(nodes[nodeId.get(knightNum)].next.val + " " + nodes[nodeId.get(knightNum)].prev.val);

            pop(nodes[nodeId.get(knightNum)]);
        }
    }
}