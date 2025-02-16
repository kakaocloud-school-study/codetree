package lim.수학;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_6280_지도_자동_구축 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static void sol() throws IOException {
        int rows = ((int) Math.pow(2, n)) + 1;
        bw.write(rows * rows + "");
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
