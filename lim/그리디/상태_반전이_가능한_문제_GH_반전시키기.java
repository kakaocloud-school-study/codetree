package lim.그리디;

import java.util.*;
import java.io.*;

public class 상태_반전이_가능한_문제_GH_반전시키기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        int answer = 0;
        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            if (prev == 0 && arr[i] == 1) {
                answer++;
            }
            prev = arr[i];
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        String word1 = br.readLine();
        String word2 = br.readLine();
        for (int i = 0; i < arr.length; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                arr[i] = 1;
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}