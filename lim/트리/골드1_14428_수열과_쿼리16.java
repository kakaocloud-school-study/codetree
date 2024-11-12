package lim.트리;

import java.util.*;
import java.io.*;

public class 골드1_14428_수열과_쿼리16 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[][] queries;

    static class Node {
        Node left, right;
        int lIdx, rIdx, minValIdx;

        Node(int lIdx, int rIdx) {
            this.lIdx = lIdx;
            this.rIdx = rIdx;
            this.minValIdx = lIdx;
        }

        int[] joint(int lIdx, int rIdx) {
            if (!(this.lIdx <= rIdx && lIdx <= this.rIdx)) {
                return null;
            }
            return new int[] { Math.max(this.lIdx, lIdx), Math.min(this.rIdx, rIdx) };
        }
    }

    static class SegmentTree {
        int[] arr;
        Node root;

        SegmentTree(int[] arr, int lIdx, int rIdx) {
            this.arr = arr;
            this.root = create(lIdx, rIdx);
        }

        private int mergeValue(Node node1, Node node2) {
            return mergeValue(node1.minValIdx, node2.minValIdx);
        }

        private int mergeValue(int idx1, int idx2) {
            if (arr[idx1] == arr[idx2]) {
                return Math.min(idx1, idx2);
            }
            return arr[idx1] < arr[idx2] ? idx1 : idx2;
        }

        private Node create(int lIdx, int rIdx) {
            Node node = new Node(lIdx, rIdx);
            if (lIdx == rIdx) {
                return node;
            }

            int mid = (lIdx + rIdx) / 2;
            node.left = create(lIdx, mid);
            node.right = create(mid + 1, rIdx);

            node.minValIdx = mergeValue(node.left, node.right);
            return node;
        }

        private int find(Node node, int lIdx, int rIdx) {
            if (lIdx == node.lIdx && rIdx == node.rIdx) {
                return node.minValIdx;
            }

            int minValIdx = lIdx;
            if (node.left != null && node.left.joint(lIdx, rIdx) != null) {
                int[] range = node.left.joint(lIdx, rIdx);
                minValIdx = mergeValue(minValIdx, find(node.left, range[0], range[1]));
            }
            if (node.right != null && node.right.joint(lIdx, rIdx) != null) {
                int[] range = node.right.joint(lIdx, rIdx);
                minValIdx = mergeValue(minValIdx, find(node.right, range[0], range[1]));
            }

            return minValIdx;
        }

        private void modify(Node node, int idx, int newVal) {
            if (idx == node.lIdx && idx == node.rIdx) {
                arr[idx] = newVal;
                return;
            }

            if (node.left != null && node.left.joint(idx, idx) != null) {
                modify(node.left, idx, newVal);
                node.minValIdx = mergeValue(node.left, node.right);
            }
            if (node.right != null && node.right.joint(idx, idx) != null) {
                modify(node.right, idx, newVal);
                node.minValIdx = mergeValue(node.left, node.right);
            }
        }

        int find(int lIdx, int rIdx) {
            return find(root, lIdx, rIdx);
        }

        void modify(int idx, int newVal) {
            modify(root, idx, newVal);
        }
    }

    static void sol() throws IOException {
        SegmentTree segmentTree = new SegmentTree(arr, 1, arr.length - 1);
        for (int[] query : queries) {
            if (query[0] == 1) {
                segmentTree.modify(query[1], query[2]);
            } else {
                bw.write(segmentTree.find(query[1], query[2]) + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        queries = new int[m][3];
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