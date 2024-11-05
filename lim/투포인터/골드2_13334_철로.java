package lim.투포인터;

import java.util.*;
import java.io.*;

public class 골드2_13334_철로 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, d;
    static int[][] segments;

    static class Point implements Comparable<Point> {
        int x, idx;
        boolean isStart;

        public Point(int x, int idx, boolean isStart) {
            this.x = x;
            this.isStart = isStart;
            this.idx = idx;
        }

        int calDistWith(Point o) {
            return Math.abs(this.x - o.x);
        }

        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }

    static void sol() throws IOException {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < segments.length; i++) {
            points.add(new Point(segments[i][0], i, true));
            points.add(new Point(segments[i][1], i, false));
        }
        Collections.sort(points);

        int answer = 0;
        int wndCount = 0;
        int[] idxCounts = new int[segments.length];
        int eIdx = 0;
        for (int i = 0; i < points.size(); i++) {
            while (eIdx < points.size() && points.get(i).calDistWith(points.get(eIdx)) <= d) {
                Point point = points.get(eIdx);
                idxCounts[point.idx]++;
                if (idxCounts[point.idx] == 2) {
                    wndCount++;
                }
                eIdx++;
            }
            answer = Math.max(answer, wndCount);
            Point point = points.get(i);
            idxCounts[point.idx]--;
            if (idxCounts[point.idx] == 1) {
                wndCount--;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        segments = new int[n][2];
        for (int i = 0; i < segments.length; i++) {
            st = new StringTokenizer(br.readLine());
            segments[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        }
        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}