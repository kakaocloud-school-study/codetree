package lim.시뮬레이션;

import java.util.Scanner;

public class 격자_안에서_완전탐색_겹쳐지지_않는_두_직사각형 {
    private static int n;
    private static int m;
    private static int[][] grid;

    static class Rectangle {
        int sr;
        int sc;
        int er;
        int ec;

        Rectangle(int sr, int sc, int er, int ec) {
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
        }

        public int sum() {
            int total = 0;
            for (int i = sr; i <= er; i++) {
                for (int j = sc; j <= ec; j++) {
                    total += grid[i][j];
                }
            }
            return total;
        }

        public boolean splitable(Rectangle r) {
            return this.er < r.sr || this.ec < r.sc || r.er < this.sr || r.ec < this.sc;
        }
    }

    private static void sol() {
        int maxValue = Integer.MIN_VALUE;
        for (int sr1 = 0; sr1 < n; sr1++) {
            for (int sc1 = 0; sc1 < m; sc1++) {
                for (int er1 = sr1; er1 < n; er1++) {
                    for (int ec1 = sc1; ec1 < m; ec1++) {
                        Rectangle r1 = new Rectangle(sr1, sc1, er1, ec1);
                        for (int sr2 = 0; sr2 < n; sr2++) {
                            for (int sc2 = 0; sc2 < m; sc2++) {
                                for (int er2 = sr2; er2 < n; er2++) {
                                    for (int ec2 = sc2; ec2 < m; ec2++) {
                                        Rectangle r2 = new Rectangle(sr2, sc2, er2, ec2);
                                        if (!r1.splitable(r2)) {
                                            continue;
                                        }
                                        // System.out.printf("%d, %d, %d, %d\n", sr1, sc1, er1, ec1);
                                        // System.out.printf("%d, %d, %d, %d\n", sr2, sc2, er2, ec2);
                                        // System.out.printf("%d, %d\n", r1.sum(), r2.sum());
                                        maxValue = Math.max(maxValue, r1.sum() + r2.sum());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(maxValue);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        sol();
        scanner.close();
    }
}
