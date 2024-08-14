package lim.미분류;

import java.util.*;
import java.io.*;

public class 스위치_켜고_끄기_실버4_1244 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] switches;
    static int[][] queries;

    static void toggle(int s, int e) {
        for (int i = s; i < e + 1; i++) {
            switches[i] ^= 1;
        }
    }

    static void toggle(int num) {
        int cur = num;
        while (cur - 1 < switches.length) {
            switches[cur - 1] ^= 1;
            cur += num;
        }
    }

    static void sol() throws IOException {
        for (int[] q : queries) {
            int op = q[0];
            int num = q[1];
            if (op == 1) {
                toggle(num);
            } else if (op == 2) {
                int s = num - 1;
                int e = num - 1;
                while (s - 1 >= 0 && e + 1 < switches.length && switches[s - 1] == switches[e + 1]) {
                    s--;
                    e++;
                }
                toggle(s, e);
            }
        }
        for (int i = 0; i < switches.length; i++) {
            bw.write(switches[i] + " ");
            if ((i + 1) % 20 == 0) {
                bw.write("\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        switches = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < switches.length; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        queries = new int[m][2];
        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}