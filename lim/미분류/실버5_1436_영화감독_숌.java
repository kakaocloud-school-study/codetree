package lim.미분류;

import java.util.*;
import java.io.*;

public class 실버5_1436_영화감독_숌 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static boolean is666(int num) {
        String word = num + "";
        if (word.length() < 3) {
            return false;
        }
        for (int i = 0; i + 2 < word.length(); i++) {
            if (word.charAt(i) == '6' && word.charAt(i + 1) == '6' && word.charAt(i + 2) == '6') {
                return true;
            }
        }
        return false;
    }

    static void sol() throws IOException {
        int num = 666;
        int order = 1;
        while (order < n) {
            num++;
            if (is666(num)) {
                order++;
            }
        }
        bw.write(num + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}