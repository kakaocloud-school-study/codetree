package lim.미분류;

import java.util.*;
import java.io.*;

public class 회전_초밥_실버1_2531 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, d, k, couponNum;
    static int[] arr;

    static void sol() throws IOException {
        int answer = 0;
        int eIdx = 0;
        HashMap<Integer, Integer> countByDish = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            while (eIdx < i + k) {
                int dish = arr[eIdx % arr.length];
                countByDish.put(dish, countByDish.getOrDefault(dish, 0) + 1);
                eIdx++;
            }
            int dishCount = countByDish.size();
            if (countByDish.get(couponNum) == null) {
                dishCount++;
            }
            answer = Math.max(answer, dishCount);
            if (countByDish.get(arr[i]) == 1) {
                countByDish.remove(arr[i]);
            } else {
                countByDish.put(arr[i], countByDish.get(arr[i]) - 1);
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        couponNum = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
