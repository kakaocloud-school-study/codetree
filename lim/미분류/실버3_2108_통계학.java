package lim.미분류;

import java.io.*;
import java.util.*;

public class 실버3_2108_통계학 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    static void sol() throws IOException {
        Arrays.sort(arr);

        int sumVal = 0;
        for (int num : arr) {
            sumVal += num;
        }
        bw.write(((int) Math.round(sumVal / (double) arr.length)) + "\n");

        bw.write(arr[arr.length / 2] + "\n");

        HashMap<Integer, Integer> countByNum = new HashMap<>();
        for (int num : arr) {
            countByNum.put(num, countByNum.getOrDefault(num, 0) + 1);
        }
        int maxCount = Collections.max(countByNum.values());
        ArrayList<Integer> preqNums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : countByNum.entrySet()) {
            int num = e.getKey();
            int count = e.getValue();
            if (count < maxCount) {
                continue;
            }
            preqNums.add(num);
        }
        Collections.sort(preqNums);
        bw.write((preqNums.size() > 1 ? preqNums.get(1) : preqNums.get(0)) + "\n");

        bw.write(arr[arr.length - 1] - arr[0] + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
