/*
 * 세그먼트 트리 정석
 */
package lim.트리;

import java.util.*;
import java.io.*;

public class 골드1_2357_최솟값과_최댓값 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;
    static int[][] queries;

    static class Node {
        int sIdx, eIdx, minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
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
            node.minVal = arr[sIdx];
            node.maxVal = arr[sIdx];
            return node;
        }

        int midIdx = (sIdx + eIdx) / 2;
        node.left = setSegTree(arr, sIdx, midIdx);
        node.right = setSegTree(arr, midIdx + 1, eIdx);

        if (node.left != null) {
            node.minVal = Math.min(node.minVal, node.left.minVal);
            node.maxVal = Math.max(node.maxVal, node.left.maxVal);
        }
        if (node.right != null) {
            node.minVal = Math.min(node.minVal, node.right.minVal);
            node.maxVal = Math.max(node.maxVal, node.right.maxVal);
        }
        return node;
    }

    static int[] findMinMax(Node node, int sIdx, int eIdx) {
        if (node.sIdx == sIdx && node.eIdx == eIdx) {
            return new int[] { node.minVal, node.maxVal };
        }

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        Node left = node.left;
        if (left != null && left.overlap(sIdx, eIdx)) {
            int[] range = left.getOverlapRange(sIdx, eIdx);
            int[] leftMinMax = findMinMax(left, range[0], range[1]);
            minVal = Math.min(minVal, leftMinMax[0]);
            maxVal = Math.max(maxVal, leftMinMax[1]);
        }

        Node right = node.right;
        if (right != null && right.overlap(sIdx, eIdx)) {
            int[] range = right.getOverlapRange(sIdx, eIdx);
            int[] rightMinMax = findMinMax(right, range[0], range[1]);
            minVal = Math.min(minVal, rightMinMax[0]);
            maxVal = Math.max(maxVal, rightMinMax[1]);
        }

        return new int[] { minVal, maxVal };
    }

    static void sol() throws IOException {
        Node root = setSegTree(arr, 0, arr.length - 1);
        for (int[] query : queries) {
            int[] minMax = findMinMax(root, query[0] - 1, query[1] - 1);
            bw.write(minMax[0] + " " + minMax[1] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        queries = new int[m][2];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}