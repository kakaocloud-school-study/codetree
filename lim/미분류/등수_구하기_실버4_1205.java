package lim.미분류;

import java.util.*;
import java.io.*;

public class 등수_구하기_실버4_1205 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, myScore, listSize;
    static int[] arr;

    static void sol() throws IOException {
        HashMap<Integer, Integer> rankByScore = new HashMap<>();
        int myRank = -1;
        for (int i = 0; i < arr.length; i++) {
            int currRank = i + 1;
            if (myScore > arr[i]) {
                myRank = rankByScore.getOrDefault(myScore, currRank);
                break;
            }
            int newRank = rankByScore.getOrDefault(arr[i], currRank);
            rankByScore.put(arr[i], newRank);
        }
        if (n == listSize && myScore <= arr[arr.length - 1]) {
            myRank = -1;
        }
        if (n < listSize && myScore == arr[arr.length - 1]) {
            myRank = rankByScore.get(arr[arr.length - 1]);
        }
        if (n < listSize && myScore < arr[arr.length - 1]) {
            myRank = n + 1;
        }

        bw.write(myRank + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        myScore = Integer.parseInt(st.nextToken());
        listSize = Integer.parseInt(st.nextToken());

        if (n == 0 && listSize > 0) {
            bw.write("1");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        arr = new int[n];
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}