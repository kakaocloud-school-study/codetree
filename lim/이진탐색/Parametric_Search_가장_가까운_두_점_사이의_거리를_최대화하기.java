package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_가장_가까운_두_점_사이의_거리를_최대화하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Segment[] segments;

    static class Segment implements Comparable<Segment> {
        long s, e;

        Segment(long s, long e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Segment segment) {
            return this.s - segment.s < 0 ? -1 : 1;
        }
    }

    static boolean check(long minDist) {
        long prevPos = Long.MIN_VALUE;
        for (Segment segment : segments) {
            if (segment.e < prevPos + minDist) {
                return false;
            }
            prevPos = Math.max(segment.s, prevPos + minDist);
        }
        return true;
    }

    static void sol() throws IOException {
        Arrays.sort(segments);
        long left = 1, right = 1_000_000_000L;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        segments = new Segment[n];
        for (int i = 0; i < segments.length; i++) {
            st = new StringTokenizer(br.readLine());
            segments[i] = new Segment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
