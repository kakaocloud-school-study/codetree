package lim.시뮬레이션;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_6270_GBC {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Segment> limits = new ArrayList<>();
    static ArrayList<Segment> ops = new ArrayList<>();

    static class Segment {
        int s, e, speed;

        public Segment(int s, int e, int speed) {
            this.s = s;
            this.e = e;
            this.speed = speed;
        }

        boolean isOverlap(Segment o) {
            return this.s < o.e && o.s < this.e;
        }
    }

    static void sol() throws IOException {
        int maxOver = 0;
        int opIdx = 0;
        for (Segment limit : limits) {
            if (opIdx > 0 && limit.isOverlap(ops.get(opIdx - 1))) {
                maxOver = Math.max(maxOver, ops.get(opIdx - 1).speed - limit.speed);
            }
            while (opIdx < ops.size() && limit.isOverlap(ops.get(opIdx))) {
                maxOver = Math.max(maxOver, ops.get(opIdx).speed - limit.speed);
                opIdx++;
            }
        }
        bw.write(maxOver + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int prevH = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int segLen = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            limits.add(new Segment(prevH, prevH + segLen, speed));
            prevH += segLen;
        }

        prevH = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int segLen = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            ops.add(new Segment(prevH, prevH + segLen, speed));
            prevH += segLen;
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
