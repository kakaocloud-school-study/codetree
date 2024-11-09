/*
 * 배열을 정렬후 i번째 언소가 최대or최소가 되는 집합 개수를 바로 구할 수 있음 2^i - 1
 * sum(i번 최대되는 집합 개수 * i번 값) - sum(i번 최소되는 집합 개수 * i번 값) 으로 구해짐
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 골드2_15824_너_봄에는_캡사이신이_맛있단다 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;
    static final int MOD = 1_000_000_007;

    static long pow(long n, int repeat) {
        if (repeat == 1) {
            return n % MOD;
        }

        long halfRepeated = pow(n, repeat / 2);
        if (repeat % 2 == 0) {
            return (halfRepeated * halfRepeated) % MOD;
        } else {
            return (((halfRepeated * halfRepeated) % MOD) * n) % MOD;
        }
    }

    static void sol() throws IOException {
        Arrays.sort(arr);
        long total = 0;
        for (int i = 1; i < arr.length; i++) {
            long count = pow(2, i) - 1;
            total += (count * arr[i]) % MOD;
            total %= MOD;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            long count = pow(2, arr.length - 1 - i) - 1;
            total -= (count * arr[i]) % MOD;
            total %= MOD;
        }
        if (total < 0) {
            total = (total + MOD) % MOD;
        }
        bw.write(total + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
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