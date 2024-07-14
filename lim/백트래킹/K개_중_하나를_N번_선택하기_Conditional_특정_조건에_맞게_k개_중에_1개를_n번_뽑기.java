package lim.백트래킹;

import java.util.*;

public class K개_중_하나를_N번_선택하기_Conditional_특정_조건에_맞게_k개_중에_1개를_n번_뽑기 {
    static int getCount(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            return 0;
        }
        int prev = arr.get(arr.size() - 1);
        int count = 1;
        for (int i = arr.size() - 2; i >= 0; i--) {
            if (prev == arr.get(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    static void func(int k, int n, ArrayList<Integer> arr) {
        if (n == arr.size()) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr.add(i);
            if (getCount(arr) < 3) {
                func(k, n, arr);
            }
            arr.remove(arr.size() - 1);
        }
    }

    static void sol(int k, int n) {
        func(k, n, new ArrayList<>());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        sol(k, n);
        scanner.close();
    }
}