package lim.LR테크닉;

import java.io.*;
import java.util.*;

public class 소프티어_lv3_6247_자동차_테스트 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr, queries;

    static void sol() throws IOException {
        Arrays.sort(arr);
        HashMap<Integer, Integer> orderByNum = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            orderByNum.put(arr[i], i);
        }

        for (int q : queries) {
            int order = orderByNum.getOrDefault(q, 0);
            int ltCount = order;
            int gtCount = arr.length - ltCount - 1;
            bw.write(ltCount * gtCount + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        arr = new int[n];
        queries = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < queries.length; i++) {
            queries[i] = Integer.parseInt(br.readLine());
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
