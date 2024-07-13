/*
 * 그리디로 쉽게 풀 수 있음
 */
package lim.백트래킹;

import java.util.*;

public class K개_중_하나를_N번_선택하기_Simple_겹치지_않게_선분_고르기 {
    static int n;
    static Stick[] sticks;

    static class Stick {
        int s, e;

        Stick(int s, int e) {
            this.s = s;
            this.e = e;
        }

        boolean isOverlap(Stick other) {
            return !(e < other.s || other.e < s);
        }
    }

    private static void sol() {
        Stick prev = sticks[0];
        int count = 1;
        for (int i = 1; i < sticks.length; i++) {
            Stick stick = sticks[i];
            if (!stick.isOverlap(prev)) {
                prev = stick;
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        sticks = new Stick[n];
        for (int i = 0; i < n; i++) {
            sticks[i] = new Stick(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(sticks, (s1, s2) -> s1.e - s2.e);
        sol();
        scanner.close();
    }
}
