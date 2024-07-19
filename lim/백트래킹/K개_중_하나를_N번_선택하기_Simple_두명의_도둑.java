/*
 * 백트래킹 안에서 또 백트래킹 로직을 중첩하여 풀이함
 * 두 도둑 좌표 설정을 위해 첫번째 백트래킹, 특정 지점에서 얻을 수 있는 최대 가치를 구하기 위해 두번째 백트래킹
 */
package lim.백트래킹;

import java.util.*;

public class K개_중_하나를_N번_선택하기_Simple_두명의_도둑 {
    static int n, m, c;
    static int[][] weightGrid;
    static int[] positions = new int[4];

    static class Thief {
        int r, c;

        Thief(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int getSum(Thief thief, int offset, int weightSum, int valueSum) {
        if (offset == m || thief.c + offset == n) {
            return valueSum;
        }

        int weight = weightGrid[thief.r][thief.c + offset];
        int value = weight * weight;

        if (weightSum + weight > c) {
            return getSum(thief, offset + 1, weightSum, valueSum);
        }
        return Math.max(getSum(thief, offset + 1, weightSum + weight, valueSum + value),
                getSum(thief, offset + 1, weightSum, valueSum));
    }

    static boolean isOverlap(Thief t1, Thief t2) {
        if (t1.r != t2.r) {
            return false;
        }
        int s1 = t1.c;
        int s2 = t2.c;
        int e1 = t1.c + m - 1;
        int e2 = t2.c + m - 1;
        return !(e1 < s2 || e2 < s1);
    }

    static int func(int idx) {
        if (idx == 4) {
            Thief t1 = new Thief(positions[0], positions[1]);
            Thief t2 = new Thief(positions[2], positions[3]);
            if (isOverlap(t1, t2)) {
                return 0;
            }
            int sum1 = getSum(t1, 0, 0, 0);
            int sum2 = getSum(t2, 0, 0, 0);

            // System.out.println(getSum(new Thief(1, 0)));
            // System.out.println(getSum(new Thief(3, 3)));
            // if (sum1 + sum2 == 198) {
            // System.out.printf("%d, %d, %d, %d \n", positions[0], positions[1],
            // positions[2], positions[3]);
            // }
            // System.out.printf("%d, %d, %d, %d \n", positions[0], positions[1],
            // positions[2], positions[3]);
            return sum1 + sum2;
        }

        int maxSum = 0;
        for (int i = 0; i < weightGrid.length; i++) {
            positions[idx] = i;
            maxSum = Math.max(func(idx + 1), maxSum);
        }
        return maxSum;
    }

    static void sol() {
        System.out.println(func(0));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        c = scanner.nextInt();
        weightGrid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                weightGrid[i][j] = scanner.nextInt();
            }
        }
        sol();
        scanner.close();
    }
}
