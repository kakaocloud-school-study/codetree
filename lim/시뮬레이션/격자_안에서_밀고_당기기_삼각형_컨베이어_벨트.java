package lim.시뮬레이션;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 격자_안에서_밀고_당기기_삼각형_컨베이어_벨트
 */
public class 격자_안에서_밀고_당기기_삼각형_컨베이어_벨트 {
    private static int n;
    private static int t;
    private static LinkedList<Integer> queue;

    private static void sol() {
        for (int i = 0; i < t; i++) {
            int last = queue.pollLast();
            queue.offerFirst(last);
        }
        for (int i = 0; i < n; i++) {
            int e = queue.poll();
            System.out.printf("%d ", e);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            int e = queue.poll();
            System.out.printf("%d ", e);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            int e = queue.poll();
            System.out.printf("%d ", e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        t = scanner.nextInt() % (3 * n);
        queue = new LinkedList<>();
        for (int i = 0; i < 3 * n; i++) {
            queue.offer(scanner.nextInt());
        }
        sol();
        scanner.close();
    }
}