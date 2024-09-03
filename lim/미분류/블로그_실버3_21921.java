package lim.미분류;

import java.util.*;
import java.io.*;

public class 블로그_실버3_21921 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, wndSize;
    static int[] arr;

    static void sol() throws IOException {
        int count = 0;
        int maxWndSum = 0;

        int eIdx = 0;
        int wndSum = 0;
        for (int sIdx = 0; sIdx < n; sIdx++) {
            while (eIdx < n && eIdx - sIdx < wndSize) {
                wndSum += arr[eIdx++];
            }

            if (wndSum > maxWndSum) {
                maxWndSum = wndSum;
                count = 1;
            } else if (wndSum == maxWndSum) {
                count++;
            }

            wndSum -= arr[sIdx];
        }

        if (maxWndSum == 0) {
            bw.write("SAD");
            return;
        }
        bw.write(maxWndSum + "\n");
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        wndSize = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}