package lim.미분류;

import java.util.*;
import java.io.*;

public class 예산_실버2_2512 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] requests;
    static int n, budget;

    static boolean possible(int limit) {
        int total = 0;
        for (int i = 0; i < requests.length; i++) {
            if (requests[i] > limit) {
                total += limit;
                continue;
            }
            total += requests[i];
        }
        return total <= budget;
    }

    static void sol() throws IOException {
        final int MAX_BUDGET = 1_000_000_000;
        int left = 1;
        int right = MAX_BUDGET;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (answer == MAX_BUDGET) {
            int maxRequest = 0;
            for (int i = 0; i < requests.length; i++) {
                maxRequest = Math.max(maxRequest, requests[i]);
            }
            answer = maxRequest;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        requests = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        budget = Integer.parseInt(st.nextToken());
        sol();
        br.close();
    }
}
