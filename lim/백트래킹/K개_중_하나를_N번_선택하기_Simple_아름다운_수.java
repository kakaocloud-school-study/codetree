package lim.백트래킹;

import java.util.*;

public class K개_중_하나를_N번_선택하기_Simple_아름다운_수 {
    private static int func(int k, int n, LinkedList<Integer> arr) {
        if (n == arr.size()) {
            return 1;
        }

        int total = 0;
        for (int i = 1; i <= k; i++) {
            if (arr.size() + i > n) {
                continue;
            }
            int count = i;
            while (count-- > 0) {
                arr.add(i);
            }

            total += func(k, n, arr);

            count = i;
            while (count-- > 0) {
                arr.removeLast();
            }
        }
        return total;
    }

    private static void sol(int k, int n) {
        System.out.println(func(k, n, new LinkedList<>()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        sol(4, n);
        scanner.close();
    }
}
