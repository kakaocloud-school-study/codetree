package lim.백트래킹;

import java.util.*;

public class K개_중_하나를_N번_선택하기_Conditional_1차원_윷놀이 {
    static int[] steps;
    static int n, m, k;

    static int getCount(ArrayList<Integer> arr) {
        int[] dists = new int[k];
        for (int i = 0; i < n; i++) {
            int step = steps[i];
            int playerIdx = arr.get(i);
            dists[playerIdx] += step;
        }
        int count = 0;
        for (int dist : dists) {
            if (dist + 1 >= m) {
                count++;
            }
        }
        return count;
    }

    static int func(ArrayList<Integer> arr) {
        if (n == arr.size()) {
            return getCount(arr);
        }

        int maxCount = 0;
        for (int i = 0; i < k; i++) {
            arr.add(i);
            maxCount = Math.max(maxCount, func(arr));
            arr.remove(arr.size() - 1);
        }
        return maxCount;
    }

    static void sol(int n, int m, int k) {
        int count = func(new ArrayList<>());
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = scanner.nextInt();
        }
        sol(n, m, k);
        scanner.close();
    }
}