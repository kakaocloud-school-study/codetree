package lim.DP;

import java.util.*;
import java.io.*;

public class 플래5_14003_가장_긴_증가하는_부분_수열5 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr, dp, minNumIdxByLen, path;

    static int searchMaxLen(int eIdx) {
        int targetNum = arr[eIdx];
        int left = 1;
        int right = n;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (minNumIdxByLen[mid] != -1 && arr[minNumIdxByLen[mid]] < targetNum) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    static void sol() throws IOException {
        dp = new int[arr.length];
        minNumIdxByLen = new int[n + 1];
        path = new int[arr.length];
        for (int i = 0; i < minNumIdxByLen.length; i++) {
            minNumIdxByLen[i] = -1;
        }
        for (int i = 0; i < path.length; i++) {
            path[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            int len = searchMaxLen(i);
            dp[i] = len + 1;
            path[i] = minNumIdxByLen[len];
            if (minNumIdxByLen[len + 1] == -1 || arr[minNumIdxByLen[len + 1]] > arr[i]) {
                minNumIdxByLen[len + 1] = i;
            }
        }

        int maxLen = 1;
        int maxLenEIdx = 0;
        for (int i = 0; i < dp.length; i++) {
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                maxLenEIdx = i;
            }
        }

        bw.write(maxLen + "\n");
        ArrayList<Integer> answer = new ArrayList<>();
        int idx = maxLenEIdx;
        while (idx != -1) {
            answer.add(arr[idx]);
            idx = path[idx];
        }
        Collections.reverse(answer);
        for (int num : answer) {
            bw.write(num + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}