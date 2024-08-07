/**
 * 
 * 풀이방식은 해결한 사람들과 같은데 어째서인지 처음부터 바로 실패함
 * 원인을 아직 모르겠음. 예제 대입 계속 찾으나 다 맞음.
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 그래프_트리_분할_골드1_22954 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] roots;
    static int[][] edges;
    static HashSet<Integer> leafNodes = new HashSet<>();
    static HashSet<Integer> selectedEdges = new HashSet<>();

    static int getRoot(int num) {
        int currNum = num;
        while (roots[currNum] != currNum) {
            currNum = roots[currNum];
        }
        roots[num] = currNum;
        return roots[num];
    }

    static void union(int a, int b, int bindingEdge) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        roots[bRoot] = aRoot;
    }

    static boolean isUnion(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        return getRoot(aRoot) == getRoot(bRoot);
    }

    static void printTrees() throws IOException {
        ArrayList<Integer> aNodes = new ArrayList<>();
        ArrayList<Integer> bNodes = new ArrayList<>();
        for (int i = 1; i < roots.length; i++) {
            if (roots[1] == roots[i]) {
                aNodes.add(i);
            } else {
                bNodes.add(i);
            }
        }

        if (aNodes.size() == bNodes.size()) {
            bw.write("-1");
            return;
        }

        bw.write(aNodes.size() + " " + bNodes.size() + "\n");

        for (int node : aNodes) {
            bw.write(node + " ");
        }
        bw.write("\n");

        ArrayList<Integer> aEdges = new ArrayList<>();
        for (int edge : selectedEdges) {
            if (isUnion(1, edges[edge][0])) {
                aEdges.add(edge);
            }
        }
        if (aEdges.size() > 0) {
            for (int edge : aEdges) {
                bw.write(edge + " ");
            }
            bw.write("\n");
        }

        for (int node : bNodes) {
            bw.write(node + " ");
        }
        bw.write("\n");

        ArrayList<Integer> bEdges = new ArrayList<>();
        for (int edge : selectedEdges) {
            if (!isUnion(1, edges[edge][0])) {
                bEdges.add(edge);
            }
        }
        if (bEdges.size() > 0) {
            for (int edge : bEdges) {
                bw.write(edge + " ");
            }
            bw.write("\n");
        }
    }

    static void separate() {
        int[] degrees = new int[roots.length];
        for (int edge : selectedEdges) {
            int node1 = edges[edge][0];
            int node2 = edges[edge][1];
            degrees[node1]++;
            degrees[node2]++;
        }

        int leaf = 0;
        for (int i = 1; i < degrees.length; i++) {
            if (degrees[i] == 1 && roots[i] != i) {
                leaf = i;
                break;
            }
        }
        roots[leaf] = leaf;

        int deletedEdge = 0;
        for (int edge : selectedEdges) {
            int node1 = edges[edge][0];
            int node2 = edges[edge][1];
            if (node1 == leaf || node2 == leaf) {
                deletedEdge = edge;
                break;
            }
        }
        selectedEdges.remove(deletedEdge);
    }

    static void sol() throws IOException {
        if (n < 3) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }

        int edgeCount = 0;
        for (int i = 1; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if (isUnion(node1, node2)) {
                continue;
            }
            union(node1, node2, i);
            selectedEdges.add(i);

            edgeCount++;
            if (edgeCount == n - 1) {
                break;
            }
        }

        if (edgeCount < n - 2) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }
        if (edgeCount == n - 1) {
            separate();
        }
        printTrees();

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        roots = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            roots[i] = i;
        }

        edges = new int[m + 1][2];
        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        sol();
        br.close();
    }
}
