package lim.미분류;

import java.util.*;
import java.io.*;

public class 실버4_18110_solved_ac {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    static void sol() throws IOException {
        Arrays.sort(arr);
        int sideCount = (int) Math.round(0.15 * arr.length);
        int scoreSum = 0;
        for (int i = sideCount; i < arr.length - sideCount; i++) {
            scoreSum += arr[i];
        }
        bw.write(arr.length == 0 ? "0" : (int) Math.round(scoreSum / ((float) (arr.length - sideCount * 2))) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
