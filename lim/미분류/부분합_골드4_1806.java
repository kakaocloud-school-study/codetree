package lim.미분류;

import java.util.*;
import java.io.*;

public class 부분합_골드4_1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, s;
    static int[] arr;

    static void sol() throws IOException {
        int answer = Integer.MAX_VALUE;
        int eIdx = 0;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            while (eIdx < arr.length && currSum < s) {
                currSum += arr[eIdx];
                eIdx++;
            }
            if (currSum >= s) {
                answer = Math.min(answer, eIdx - i);
            }
            currSum -= arr[i];
        }
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
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
