package lim.미분류;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_6269_비밀_메뉴 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] pattern, arr;

    static boolean check(int sIdx) {
        for (int i = 0; i < pattern.length; i++) {
            if (sIdx + i >= arr.length || pattern[i] != arr[sIdx + i]) {
                return false;
            }
        }
        return true;
    }

    static void sol() throws IOException {
        for (int i = 0; i < arr.length; i++) {
            if (check(i)) {
                bw.write("secret");
                return;
            }
        }
        bw.write("normal");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        pattern = new int[m];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pattern.length; i++) {
            pattern[i] = Integer.parseInt(st.nextToken());
        }

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
