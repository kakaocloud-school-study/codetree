/*
 * 다시 풀기
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 플래5_1708_볼록_껍질 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Point[] points;

    static class Point implements Comparable<Point> {
        static Point base = null;
        long x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;

            if (base == null || base.y > this.y) {
                base = this;
            } else if (base.y == this.y && base.x > this.x) {
                base = this;
            }
        }

        long getDist(Point o) {
            return (this.x - o.x) * (this.x - o.x) + (this.y - o.y) * (this.y - o.y);
        }

        @Override
        public int compareTo(Point o) {
            long ccwVal = ccw(base, this, o);
            if (ccwVal > 0) {
                return -1;
            } else if (ccwVal < 0) {
                return 1;
            } else {
                return this.getDist(base) < o.getDist(base) ? -1 : 1;
            }
        }
    }

    static long ccw(Point p1, Point p2, Point p3) {
        long x1 = p2.x - p1.x, y1 = p2.y - p1.y;
        long x2 = p3.x - p2.x, y2 = p3.y - p2.y;
        return x1 * y2 - x2 * y1;
    }

    static void sol() throws IOException {
        Arrays.sort(points);

        LinkedList<Point> stack = new LinkedList<>();
        for (int i = 0; i < points.length; i++) {
            if (stack.size() < 2) {
                stack.offer(points[i]);
                continue;
            }
            Point p3 = points[i];
            Point p2 = stack.pollLast();
            Point p1 = stack.getLast();
            while (!stack.isEmpty() && ccw(p1, p2, p3) <= 0) {
                p2 = stack.pollLast();
                if (!stack.isEmpty()) {
                    p1 = stack.getLast();
                }
            }
            stack.offer(p2);
            stack.offer(p3);
        }
        bw.write(stack.size() + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        points = new Point[n];
        for (int i = 0; i < points.length; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}