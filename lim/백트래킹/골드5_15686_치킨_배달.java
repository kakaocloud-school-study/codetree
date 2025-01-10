package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 골드5_15686_치킨_배달 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Point> shops = new ArrayList<>();
    static ArrayList<Point> homes = new ArrayList<>();
    static int m;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        int getDistFrom(Point point) {
            return Math.abs(this.r - point.r) + Math.abs(this.c - point.c);
        }
    }

    static int getMinDist(Point home, ArrayList<Point> selectedShops) {
        int minDist = Integer.MAX_VALUE;
        for (Point shop : selectedShops) {
            minDist = Math.min(minDist, home.getDistFrom(shop));
        }
        return minDist;
    }

    static int func(int shopIdx, ArrayList<Point> selectedShops) {
        if (selectedShops.size() == m) {
            int totalDist = 0;
            for (Point home : homes) {
                totalDist += getMinDist(home, selectedShops);
            }
            return totalDist;
        }
        if (shopIdx >= shops.size()) {
            return Integer.MAX_VALUE;
        }

        int minTotalDist = Integer.MAX_VALUE;
        selectedShops.add(shops.get(shopIdx));
        minTotalDist = Math.min(minTotalDist, func(shopIdx + 1, selectedShops));
        selectedShops.remove(selectedShops.size() - 1);
        minTotalDist = Math.min(minTotalDist, func(shopIdx + 1, selectedShops));

        return minTotalDist;
    }

    static void sol() throws IOException {
        bw.write(func(0, new ArrayList<>())+ "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    homes.add(new Point(i, j));
                } else if (num == 2) {
                    shops.add(new Point(i, j));
                }
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
