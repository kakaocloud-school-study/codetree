package lim.미분류;

import java.util.*;
import java.io.*;

public class 겹치는_건_싫어_실버1_20922 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, upperBound;
    static int[] arr;
    static HashMap<Integer, Integer> countByNum = new HashMap<>();

    static void sol() throws IOException {
        int eIdx = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            while (eIdx < arr.length) {
                int count = countByNum.getOrDefault(arr[eIdx], 0);
                if (count >= upperBound) {
                    break;
                }
                countByNum.put(arr[eIdx], count + 1);
                eIdx++;
            }
            maxLen = Math.max(maxLen, eIdx - i);
            countByNum.put(arr[i], countByNum.get(arr[i]) - 1);
        }
        bw.write(maxLen + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        upperBound = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}