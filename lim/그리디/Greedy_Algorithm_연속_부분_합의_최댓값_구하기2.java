package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_연속_부분_합의_최댓값_구하기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        int answer = arr[0];
        int currSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += arr[i];
            answer = Math.max(answer, currSum);
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
