package lim.그리디;

import java.util.*;
import java.io.*;

public class 상태_반전이_가능한_문제_좌우_반전시키기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == 0) {
                arr[i - 1] ^= 1;
                arr[i] ^= 1;
                if (i + 1 < arr.length) {
                    arr[i + 1] ^= 1;
                }
                answer++;
            }
        }
        if (arr[arr.length - 1] == 0) {
            bw.write("-1");
            return;
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