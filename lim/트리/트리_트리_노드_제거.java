package lim.트리;

import java.util.*;
import java.io.*;

public class 트리_트리_노드_제거 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] parents;
    static int deletedNode, rootNode;

    static int getLeafs(int node) {
        int leafs = 0;
        if (node == deletedNode) {
            return 0;
        }
        for (int child = 0; child < parents.length; child++) {
            if (child == deletedNode) {
                continue;
            }
            if (parents[child] == node) {
                leafs += getLeafs(child);
            }
        }
        return Math.max(1, leafs);
    }

    static void sol() throws IOException {
        int leafs = getLeafs(rootNode);

        bw.write(String.valueOf(leafs));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        parents = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            parents[i] = parent;
            if (parent == -1) {
                rootNode = i;
            }
        }
        st = new StringTokenizer(br.readLine());
        deletedNode = Integer.parseInt(st.nextToken());
        sol();
        br.close();
    }
}
