package lim.트리;

import java.util.*;
import java.io.*;

public class 골드1_11505_구간_곱_구하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, k;
    static final long MOD = 1_000_000_007L;
    static int[] arr;
    static int[][] queries;

    static class Node {
        int sIdx, eIdx;
        long val = 1;
        Node left, right;

        public Node(int sIdx, int eIdx) {
            this.sIdx = sIdx;
            this.eIdx = eIdx;
        }

        boolean overlap(int sIdx, int eIdx) {
            return this.sIdx <= eIdx && sIdx <= this.eIdx;
        }

        int[] getOverlapRange(int sIdx, int eIdx) {
            if (!overlap(sIdx, eIdx)) {
                throw new RuntimeException();
            }
            return new int[] { Math.max(this.sIdx, sIdx), Math.min(this.eIdx, eIdx) };
        }
    }

    static Node setSegTree(int[] arr, int sIdx, int eIdx) {
        Node node = new Node(sIdx, eIdx);
        if (sIdx == eIdx) {
            node.val = arr[sIdx];
            return node;
        }

        int midIdx = (sIdx + eIdx) / 2;
        node.left = setSegTree(arr, sIdx, midIdx);
        node.right = setSegTree(arr, midIdx + 1, eIdx);

        if (node.left != null) {
            node.val *= node.left.val;
            node.val %= MOD;
        }
        if (node.right != null) {
            node.val *= node.right.val;
            node.val %= MOD;
        }
        return node;
    }

    static long findVal(Node node, int sIdx, int eIdx) {
        if (node.sIdx == sIdx && node.eIdx == eIdx) {
            return node.val;
        }

        long val = 1;

        Node left = node.left;
        if (left != null && left.overlap(sIdx, eIdx)) {
            int[] range = left.getOverlapRange(sIdx, eIdx);
            val *= findVal(left, range[0], range[1]);
            val %= MOD;
        }

        Node right = node.right;
        if (right != null && right.overlap(sIdx, eIdx)) {
            int[] range = right.getOverlapRange(sIdx, eIdx);
            val *= findVal(right, range[0], range[1]);
            val %= MOD;
        }

        return val;
    }

    static void modify(Node node, int idx, long newVal) {
        if (node.sIdx == idx && node.eIdx == idx) {
            node.val = newVal;
            return;
        }

        if (node.left != null && idx <= node.left.eIdx) {
            modify(node.left, idx, newVal);
        } else if (node.right != null) {
            modify(node.right, idx, newVal);
        }
        node.val = node.left.val * node.right.val;
        node.val %= MOD;
    }

    static void sol() throws IOException {
        Node root = setSegTree(arr, 0, arr.length - 1);
        for (int[] query : queries) {
            if (query[0] == 1) {
                int idx = query[1] - 1;
                long newVal = query[2];
                modify(root, idx, newVal);
            } else {
                int sIdx = query[1] - 1;
                int eIdx = query[2] - 1;
                bw.write(findVal(root, sIdx, eIdx) + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        queries = new int[m + k][3];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()) };
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}