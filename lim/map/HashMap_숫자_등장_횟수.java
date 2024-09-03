package lim.map;

import java.util.*;
import java.io.*;

public class HashMap_숫자_등장_횟수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr, queries;

    static void sol() throws IOException {
        HashMap<Integer, Integer> countByNum = new HashMap<>();
        for (int num : arr) {
            countByNum.put(num, countByNum.getOrDefault(num, 0) + 1);
        }
        for (int num : queries) {
            bw.write(countByNum.getOrDefault(num, 0) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        queries = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < queries.length; i++) {
            queries[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}