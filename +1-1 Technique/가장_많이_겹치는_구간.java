import java.util.*;
import java.io.*;

class Segment {
    int x1, x2;

    public Segment(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
};

public class Main {
    static final int MAX_N = 100000;
    static final int MAX_X = 200000;
    static Segment[] segments = new Segment[MAX_N];
    static int[] checked = new int[MAX_X + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            segments[i] = new Segment(x1, x2);
        }

        for (int i = 0; i < n; i++) {
            int x1 = segments[i].x1;
            int x2 = segments[i].x2;
            checked[x1] += 1;
            checked[x2] -= 1;
        }
        int ans = 0;
        int sumVal = 0;
        for (int i = 1; i <= MAX_X; i++) {
            sumVal += checked[i];
            ans = Math.max(ans, sumVal);
        }

        System.out.print(ans);
    }
}