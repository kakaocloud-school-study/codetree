package lim.백트래킹;

import java.util.*;

public class K개_중_하나를_N번_선택하기_Conditional_가능한_수열_중_최솟값_구하기 {
    static int[] nums = { 4, 5, 6 };

    static boolean equals(int s1, int e1, int s2, int e2, ArrayList<Integer> arr) {
        for (int i = 0; s1 + i <= e1; i++) {
            if (arr.get(s1 + i) != arr.get(s2 + i)) {
                return false;
            }
        }
        return true;
    }

    static boolean possible(ArrayList<Integer> arr) {
        for (int length = 1; 2 * length <= arr.size(); length++) {
            int e1 = arr.size() - 1;
            int s1 = e1 - length + 1;
            int e2 = s1 - 1;
            int s2 = e2 - length + 1;
            if (equals(s1, e1, s2, e2, arr)) {
                return false;
            }
        }
        return true;
    }

    static boolean func(int n, ArrayList<Integer> arr) {
        if (n == arr.size()) {
            for (int num : arr) {
                System.out.print(num);
            }
            return true;
        }

        for (int num : nums) {
            arr.add(num);
            if (possible(arr)) {
                if (func(n, arr)) {
                    return true;
                }
            }
            arr.remove(arr.size() - 1);
        }
        return false;
    }

    static void sol(int n) {
        func(n, new ArrayList<>());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        sol(n);
        scanner.close();
    }
}