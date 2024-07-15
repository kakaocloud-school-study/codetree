package lim.백트래킹;

import java.util.*;

public class N개_중에_M개_고르기_Simple_n개_중에_m개_뽑기 {
    private static void func(int from, int to, int m, ArrayList<Integer> arr) {
        if (m == arr.size()) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = from; i <= to; i++) {
            arr.add(i);
            func(i + 1, to, m, arr);
            arr.remove(arr.size() - 1);
        }
    }

    private static void sol(int n, int m) {
        func(1, n, m, new ArrayList<>());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        sol(n, m);
        scanner.close();
    }
}
