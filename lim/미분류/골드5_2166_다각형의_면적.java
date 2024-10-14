/*
 * 외적을 이용함...
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 골드5_2166_다각형의_면적 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Point[] points;

    static class Point {
        long x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void minus(Point p) {
            this.x -= p.x;
            this.y -= p.y;
        }
    }

    static void sol() throws IOException {
        double answer = 0;

        Point origin = new Point(0, 0);
        for (int i = 0; i < points.length; i++) {
            points[i].minus(origin);
        }

        for (int i = 1; i < points.length; i++) {
            answer += (points[i - 1].x * points[i].y - points[i].x * points[i - 1].y) / (double) 2.0;
        }
        answer += (points[n - 1].x * points[0].y - points[0].x * points[n - 1].y) / (double) 2.0;

        bw.write(String.format("%.1f", Math.abs(answer)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}