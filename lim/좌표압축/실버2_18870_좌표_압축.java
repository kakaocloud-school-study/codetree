package lim.좌표압축;

import java.util.*;
import java.io.*;

public class 실버2_18870_좌표_압축 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    static void sol() throws IOException {
        TreeMap<Integer, Integer> orderByNum = new TreeMap<>();
        for (int num : arr) {
            orderByNum.put(num, 0);
        }
        int order = 0;
        for (int num : orderByNum.keySet()) {
            orderByNum.put(num, order++);
        }
        for (int num : arr) {
            bw.write(orderByNum.get(num) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}