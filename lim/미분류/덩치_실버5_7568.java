package lim.미분류;

import java.util.*;
import java.io.*;

public class 덩치_실버5_7568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] items;

    static void sol() throws IOException {
        for (int i = 0; i < items.length; i++) {
            int count = 0;
            for (int j = 0; j < items.length; j++) {
                if (items[i][0] < items[j][0] && items[i][1] < items[j][1]) {
                    count++;
                }
            }
            bw.write(count + 1 + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        items = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
