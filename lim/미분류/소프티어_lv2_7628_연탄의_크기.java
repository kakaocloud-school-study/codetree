package lim.미분류;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_7628_연탄의_크기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    static int calCount(int unit) {
        int count = 0;
        for (int size : arr) {
            if (size % unit == 0) {
                count++;
            }
        }
        return count;
    }

    static void sol() throws IOException {
        int maxCount = 0;
        for (int unit = 2; unit <= 100; unit++) {
            maxCount = Math.max(maxCount, calCount(unit));
        }
        bw.write(maxCount + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
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
