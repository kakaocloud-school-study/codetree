import java.util.*;
import java.io.*;

public class 플러스마이너스_technique_서로_다른_구간의_수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
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
        HashSet<Integer> segIdxs = new HashSet<>();
        for (Point point : points) {
            if (point.value == 1) {
                segIdxs.add(point.idx);
            } else {
                segIdxs.remove(point.idx);
                if (segIdxs.size() == 0) {
                    answer++;
                }
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            segments[i][0] = Integer.parseInt(st.nextToken());
            segments[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
