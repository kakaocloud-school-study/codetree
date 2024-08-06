package lim.트리;

import java.util.*;
import java.io.*;

public class Disjoint_Set_Union_Find_집합의_원소 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] roots;
    static int[][] queries;

    static int getRoot(int num) {
        int currNum = num;
        while (roots[currNum] != currNum) {
            currNum = roots[currNum];
        }
        roots[num] = currNum;
        return roots[num];
    }

    static void union(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        roots[bRoot] = aRoot;
    }

    static int isUnion(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        return getRoot(aRoot) == getRoot(bRoot) ? 1 : 0;
    }

    static void sol() throws IOException {
        for (int[] query : queries) {
            int op = query[0];
            int a = query[1];
            int b = query[2];
            if (op == 0) {
                union(a, b);
            } else {
                bw.write(isUnion(a, b) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        roots = new int[n + 1];
        queries = new int[m][4];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queries[i][0] = op;
            queries[i][1] = a;
            queries[i][2] = b;
        }
        sol();
        br.close();
    }
}
