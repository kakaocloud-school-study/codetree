package lim.map;

import java.util.*;
import java.io.*;

public class HashMap_원소의_합이_0 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arrA, arrB, arrC, arrD;

    static void sol() throws IOException {
        HashMap<Integer, Integer> countByAB = new HashMap<>();
        for (int i = 0; i < arrA.length; i++) {
            for (int j = 0; j < arrB.length; j++) {
                countByAB.put(arrA[i] + arrB[j], countByAB.getOrDefault(arrA[i] + arrB[j], 0) + 1);
            }
        }

        HashMap<Integer, Integer> countByCD = new HashMap<>();
        for (int i = 0; i < arrC.length; i++) {
            for (int j = 0; j < arrD.length; j++) {
                countByCD.put(arrC[i] + arrD[j], countByCD.getOrDefault(arrC[i] + arrD[j], 0) + 1);
            }
        }

        int total = 0;
        for (Map.Entry<Integer, Integer> e : countByAB.entrySet()) {
            int ab = e.getKey();
            int abCount = e.getValue();
            int cdCount = countByCD.getOrDefault(-ab, 0);
            total += abCount * cdCount;
        }

        bw.write(total + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arrA = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        arrB = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        arrC = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrC.length; i++) {
            arrC[i] = Integer.parseInt(st.nextToken());
        }

        arrD = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrD.length; i++) {
            arrD[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}