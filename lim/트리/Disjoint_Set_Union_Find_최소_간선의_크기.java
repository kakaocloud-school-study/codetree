/*
 * 여기서는 이진탐색으로 만족도 하한을 이동시켜가며 구했지만
 * 해설에서는 그리디로 품
 */
package lim.트리;

import java.util.*;
import java.io.*;

public class Disjoint_Set_Union_Find_최소_간선의_크기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, startAt, endAt;
    static int[] roots;
    static int[][] edges;

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

    static boolean isUnion(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        return getRoot(aRoot) == getRoot(bRoot);
    }

    static boolean possible(int lowerBound) {
        for (int i = 0; i < n + 1; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int value = edge[2];
            if (value < lowerBound) {
                continue;
            }
            union(a, b);
        }
        return isUnion(startAt, endAt);
    }

    static void sol() throws IOException {
        int left = 1;
        int right = 1_000_000_000;
        int answer = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startAt = Integer.parseInt(st.nextToken());
        endAt = Integer.parseInt(st.nextToken());

        roots = new int[n + 1];
        edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = value;
        }
        sol();
        br.close();
    }
}
