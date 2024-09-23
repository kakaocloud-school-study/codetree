package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_자동차_단일_거래_이익_최대화하기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        int answer = 0;
        int currMin = arr[0];
        for (int i = 0; i < arr.length; i++) {
            currMin = Math.min(currMin, arr[i]);
            answer = Math.max(answer, arr[i] - currMin);
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
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
