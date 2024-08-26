package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ1205 {
    static int n, taesoo, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        taesoo = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        int[] score = new int[p];
        if (n > 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(score);

        if (p == n && score[0] >= taesoo) {
            System.out.println(-1);
            return;
        }

        int cnt = 1;
        for (int i = p-1; i >= 0; i--) {
            if (score[i] > taesoo) {
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}