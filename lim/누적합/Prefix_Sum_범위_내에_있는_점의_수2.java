package lim.누적합;

import java.util.*;
import java.io.*;

public class Prefix_Sum_범위_내에_있는_점의_수2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, q;
    static int[] arr, presumArr;
    static int[][] queries;

    static void sol() throws IOException {
        for (int i = 0; i < arr.length; i++) {
            presumArr[i] = arr[i];
            if (i > 0) {
                presumArr[i] += presumArr[i - 1];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0], e = queries[i][1];
            int count = presumArr[e];
            if (s > 0) {
                count -= presumArr[s - 1];
            }
            bw.write(count + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[1_000_001];
        presumArr = new int[1_000_001];
        queries = new int[q][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())] = 1;
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
