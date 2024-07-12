/*
 * printf 포맷 설정 시간때문에 시간초과났음
 */
package lim.백트래킹;

import java.util.*;

public class K개_중_하나를_N번_선택하기_Simple_k개_중에_1개를_n번_뽑기 {
    private static void func(int k, int n, LinkedList<Integer> arr) {
        if (n == arr.size()) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr.add(i);
            func(k, n, arr);
            arr.removeLast();
        }
    }

    private static void sol(int k, int n) {
        func(k, n, new LinkedList<>());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        sol(k, n);
        scanner.close();
    }
}
