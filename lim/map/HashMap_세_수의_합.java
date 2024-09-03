/*
 * 해설이랑 많이 다른 풀이
 * 해설을 한번더 봐야
 */
package lim.map;

import java.util.*;
import java.io.*;

public class HashMap_세_수의_합 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;

    static void sol() throws IOException {
        Arrays.sort(arr);
        int[] dp = new int[arr.length]; // i번숫자 다음에 있는 i번숫자와 같은 값 개수

        for (int i = 0; i < dp.length; i++) {
            int num = arr[i];
            int count = 0;
            for (int j = i + 1; j < dp.length; j++) {
                if (num == arr[j]) {
                    count++;
                }
            }
            dp[i] = count;
        }

        HashMap<Integer, Integer> countByNum = new HashMap<>();
        for (int num : arr) {
            countByNum.put(num, countByNum.getOrDefault(num, 0) + 1);
        }

        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int num1 = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int num2 = arr[j];
                int num3 = m - num1 - num2;
                if (num2 > num3) {
                    continue;
                }
                int count = countByNum.getOrDefault(num3, 0);
                if (count == 0) {
                    continue;
                }
                if (num2 == num3) {
                    total += dp[j];
                    continue;
                }

                total += count;
            }
        }
        bw.write(total + "");
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
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}