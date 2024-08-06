package lim.트리;

import java.util.*;
import java.io.*;

public class Disjoint_Set_Union_Find_경로의_적합성_판단_2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, k;
    static int[] seq, roots;

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

    static void sol() throws IOException {
        int prev = seq[0];
        int answer = 1;
        for (int i = 1; i < seq.length; i++) {
            if (!isUnion(prev, seq[i])) {
                answer = 0;
                break;
            }
            prev = seq[i];
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
        k = Integer.parseInt(st.nextToken());
        seq = new int[k];
        roots = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
