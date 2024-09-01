package lim.set;

import java.util.*;
import java.io.*;

public class HashSet_데이터_비교 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr1, arr2;

    static void sol() throws IOException {
        HashSet<Integer> nums = new HashSet<>();

        for (int num : arr1) {
            nums.add(num);
        }

        for (int num : arr2) {
            if (nums.contains(num)) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}