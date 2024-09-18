package lim.이진탐색;

import java.util.*;
import java.io.*;

public class Parametric_Search_버스를_기다리며 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, busCount, capacity;
    static int[] arr;

    static boolean check(int timeout) {
        int busNum = 1;
        int currOccupy = 1;
        int departAt = arr[0] + timeout;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= departAt && currOccupy < capacity) {
                currOccupy++;
                continue;
            }
            departAt = arr[i] + timeout;
            currOccupy = 1;
            busNum++;
        }
        return busNum <= busCount;
    }

    static void sol() throws IOException {
        Arrays.sort(arr);
        int left = 0, right = 1_000_000_000;
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
        busCount = Integer.parseInt(st.nextToken());
        capacity = Integer.parseInt(st.nextToken());
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
