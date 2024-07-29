import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x, v;

    public Point(int x, int v) {
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point p) { //x 오름차순
        return this.x - p.x;
    }
};

public class Main {
    static final int MAX_N = 100000;
    static List<Point> segments = new ArrayList<>();
    static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            segments.add(new Point(x1, x2));
        }

        //주어진 좌표의 범위가 큰 경우에는 각 선분을 두 지점으로 나눠서
        // +1, -1로 담은 뒤, 정렬
        for (int i = 0; i < n; i++) {
            int x1 = segments.get(i).x;
            int x2 = segments.get(i).v;
            points.add(new Point(x1, +1)); //시작점
            points.add(new Point(x2, -1)); //끝점
        }

        Collections.sort(points);

        //각 위치에 적혀있는 숫자들의 합을 구하면 매 순간마다 겹치는 구간의 횟수가 구해짐
        //이 중에서 최댓값 구하기
        int sumVal = 0;
        int ans = 0;

        for (int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;

            //적혀있는 가중치를 전부 더하기
            sumVal += v;

            ans = Math.max(ans, sumVal);
        }

        System.out.print(ans);
    }
}