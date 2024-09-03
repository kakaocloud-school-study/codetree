/*
 * 풀이가 해설에 비해 복잡해서 리팩톨링 필요할듯
 */
package lim.트리;

import java.util.*;
import java.io.*;

public class Disjoint_Set_Union_Find_칸_합치기_2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] roots, uStarts, uEnds;
    static HashSet<Integer> unions = new HashSet<>();
    static int[][] ranges;

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
        int aStart = uStarts[aRoot];
        int bEnd = uEnds[bRoot];

        uStarts[aRoot] = aStart;
        uEnds[aRoot] = bEnd;

        roots[bRoot] = aRoot;
        unions.remove(bRoot);
    }

    static void unionRange(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        int aEnd = uEnds[aRoot];
        int bEnd = uEnds[bRoot];

        int cur = aEnd + 1;
        while (cur <= bEnd) {
            union(aEnd, cur);
            cur = uEnds[aRoot] + 1;
        }
    }

    static boolean isUnion(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        return getRoot(aRoot) == getRoot(bRoot);
    }

    static void sol() throws IOException {
        for (int i = 0; i < ranges.length; i++) {
            unionRange(ranges[i][0], ranges[i][1]);
            bw.write(unions.size() + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        roots = new int[n + 1];
        uStarts = new int[n + 1];
        uEnds = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            roots[i] = i;
            uStarts[i] = i;
            uEnds[i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            unions.add(i);
        }

        ranges = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ranges[i][0] = a;
            ranges[i][1] = b;
        }
        sol();
        br.close();
    }
}
