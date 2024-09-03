package lim.map;

import java.util.*;
import java.io.*;

public class TreeMap_처음_등장하는_위치 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        TreeMap<Integer, Integer> countByNum = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (countByNum.get(num) == null) {
                countByNum.put(num, i + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : countByNum.entrySet()) {
            int num = e.getKey();
            int order = e.getValue();
            bw.write(num + " " + order + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}