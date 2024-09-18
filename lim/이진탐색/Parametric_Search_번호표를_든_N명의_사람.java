package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_번호표를_든_N명의_사람 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, t;
    static int[] delays;

    static boolean check(int sizeLimit) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int time = 0;
        for (int delay : delays) {
            if (queue.size() == sizeLimit) {
                time = queue.poll();
            }
            queue.add(time + delay);
        }
        while (!queue.isEmpty()) {
            time = queue.poll();
        }
        return time <= t;
    }

    static void sol() throws IOException {
        int left = 1, right = 10_000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        delays = new int[n];
        for (int i = 0; i < delays.length; i++) {
            st = new StringTokenizer(br.readLine());
            delays[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
