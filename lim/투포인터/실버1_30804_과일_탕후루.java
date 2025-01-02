package lim.투포인터;

import java.util.*;
import java.io.*;

public class 실버1_30804_과일_탕후루 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    static void sol() throws IOException {
        HashMap<Integer, Integer> countByNum = new HashMap<>();

        int maxSize = 0;
        int eIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            while (eIdx < arr.length && countByNum.size() <= 2) {
                if (countByNum.size() == 2 && countByNum.get(arr[eIdx]) == null) {
                    break;
                }
                countByNum.put(arr[eIdx], countByNum.getOrDefault(arr[eIdx], 0) + 1);
                eIdx++;
            }
            maxSize = Math.max(maxSize, eIdx - i);
            countByNum.put(arr[i], countByNum.get(arr[i]) - 1);
            if (countByNum.get(arr[i]) == 0) {
                countByNum.remove(arr[i]);
            }
        }

        bw.write(maxSize + "");
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
