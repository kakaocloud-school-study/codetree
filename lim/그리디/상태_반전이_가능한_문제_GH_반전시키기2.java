package lim.그리디;

import java.util.*;
import java.io.*;

public class 상태_반전이_가능한_문제_GH_반전시키기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        int flipCount = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if ((arr[i] + flipCount) % 2 == 1) {
                flipCount++;
            }
        }
        bw.write(flipCount + "");
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