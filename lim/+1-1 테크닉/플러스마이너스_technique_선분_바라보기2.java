import java.util.*;
import java.io.*;

public class 플러스마이너스_technique_선분_바라보기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] segments;

    static class Point implements Comparable<Point> {
        int x, y, value, idx;

        Point(int x, int y, int value, int idx) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p) {
            return this.x - p.x;
        }
    }

    static class Color implements Comparable<Color> {
        int y, idx;

        Color(int y, int idx) {
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Color p) {
            if (this.y == p.y) {
                return this.idx - p.idx;
            }
            return this.y - p.y;
        }
    }

    static void sol() throws IOException {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < segments.length; i++) {
            points.add(new Point(segments[i][1], segments[i][0], 1, i));
            points.add(new Point(segments[i][2], segments[i][0], -1, i));
        }
        Collections.sort(points);

        HashSet<Integer> idxs = new HashSet<>();
        TreeSet<Color> colorStack = new TreeSet<>();
        for (Point point : points) {
            if (!colorStack.isEmpty()) {
                idxs.add(colorStack.first().idx);
            }

            if (point.value == 1) {
                colorStack.add(new Color(point.y, point.idx));
            } else {
                colorStack.remove(new Color(point.y, point.idx));
            }

            if (!colorStack.isEmpty()) {
                idxs.add(colorStack.first().idx);
            }
        }
        bw.write(idxs.size() + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        segments = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            segments[i][0] = Integer.parseInt(st.nextToken());
            segments[i][1] = Integer.parseInt(st.nextToken());
            segments[i][2] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
