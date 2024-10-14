package lim.문자열;

import java.util.*;
import java.io.*;

public class 골드4_10942_팰린드롬 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] paddedArr;
    static int[][] queries;

    static void sol() throws IOException {
        int[] lenMaxAt = new int[paddedArr.length];
        for (int i = 0; i < lenMaxAt.length; i++) {
            int len = 0;
            while (i - len >= 0 && i + len < lenMaxAt.length && paddedArr[i - len] == paddedArr[i + len]) {
                len++;
            }
            lenMaxAt[i] = len - 1;
        }

        for (int i = 0; i < queries.length; i++) {
            int s = 2 * queries[i][0];
            int e = 2 * queries[i][1];
            int mid = (s + e) / 2;
            if (e - mid <= lenMaxAt[mid]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        paddedArr = new int[2 * n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            paddedArr[2 * i] = Integer.parseInt(st.nextToken());
            paddedArr[2 * i + 1] = -1;
        }
        paddedArr[2 * n - 2] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        queries = new int[m][2];
        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken()) - 1;
            queries[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}