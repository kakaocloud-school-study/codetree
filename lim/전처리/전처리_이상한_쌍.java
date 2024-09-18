package lim.전처리;

import java.util.*;
import java.io.*;

public class 전처리_이상한_쌍 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static int[] arr;

    static void sol() throws IOException {
        HashMap<Integer, Integer> prevBombPosByNum = new HashMap<>();
        int maxBombNum = -1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (prevBombPosByNum.get(num) != null && i - prevBombPosByNum.get(num) <= k) {
                maxBombNum = Math.max(maxBombNum, num);
            }
            prevBombPosByNum.put(num, i);
        }
        bw.write(maxBombNum + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
