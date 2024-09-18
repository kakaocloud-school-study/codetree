package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_겹치지_않는_선분위의_두_점 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
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
        Arrays.sort(segments);

        long count = 0;
        long prevPos = Long.MIN_VALUE;
        for (Segment segment : segments) {
            long currPos = segment.s;
            while (currPos <= segment.e) {
                if (prevPos == Long.MIN_VALUE || currPos - prevPos >= minDist) {
                    count++;
                    prevPos = currPos;
                }
                currPos = prevPos + minDist;
            }
        }
        return count >= n;
    }

    static void sol() throws IOException {
        long left = 1, right = 1_000_000_000L * 1_000_000_000L;
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
        m = Integer.parseInt(st.nextToken());
        segments = new Segment[m];
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
