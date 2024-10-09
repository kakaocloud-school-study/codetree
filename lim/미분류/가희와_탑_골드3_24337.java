/*
 * 기본적으로 구조는 a+b-1개 건물로 1, ..., a -1, max(a, b), b - 1, ... , 1
 * 하지만 n > (a+b-1) 이면 그 여분만큼 1을 비집어 넣어야 함. (사전순 최소로 만들어야 하니 1이 유리)
 * 대부분 그냥 맨 앞에 넣으면 되는데 a = 1인 경우 맨 앞이 max(a, b)여야 하므로 1이 못 옴
 * 그러므로 그 경우는 차선으로 max(a, b) 바로 뒤에 1을 삽입
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 가희와_탑_골드3_24337 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, a, b;

    static void sol() throws IOException {
        if ((a + b - 1) > n) {
            bw.write("-1");
            return;
        }
        int maxH = Math.max(a, b);
        int bonusCount = n - (a + b - 1);
        if (a > 1) {
            for (int i = 0; i < bonusCount; i++) {
                bw.write("1 ");
            }
        }
        for (int i = 1; i < a; i++) {
            bw.write(i + " ");
        }
        bw.write(maxH + " ");
        if (a == 1) {
            for (int i = 0; i < bonusCount; i++) {
                bw.write("1 ");
            }
        }
        for (int i = b - 1; i > 0; i--) {
            bw.write(i + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
