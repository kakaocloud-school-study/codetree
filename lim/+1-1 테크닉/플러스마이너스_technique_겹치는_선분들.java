import java.util.*;
import java.io.*;

public class 플러스마이너스_technique_겹치는_선분들 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static int[][] segments;

    static class Point implements Comparable<Point> {
        int x, value, idx;

        Point(int x, int value, int idx) {
            this.x = x;
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p) {
            return this.x - p.x;
        }
    }

    static void sol() throws IOException {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < segments.length; i++) {
            points.add(new Point(segments[i][0], 1, i));
            points.add(new Point(segments[i][1], -1, i));
        }
        Collections.sort(points);

        int answer = 0;
        int startAt = -1;
        HashSet<Integer> segIdxs = new HashSet<>();
        for (Point point : points) {
            if (point.value == 1) {
                segIdxs.add(point.idx);
                if (segIdxs.size() == k) {
                    startAt = point.x;
                }
            } else {
                if (segIdxs.size() == k) {
                    answer += point.x - startAt;
                }
                segIdxs.remove(point.idx);
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int x = 0;
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            if (direction.equals("R")) {
                segments[i][0] = x;
                segments[i][1] = x + dist;
                x += dist;
            } else {
                segments[i][0] = x - dist;
                segments[i][1] = x;
                x -= dist;
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
