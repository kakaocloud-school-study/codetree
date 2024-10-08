/*
 * 어느 한 지점에서 기울기를 갱신해가는 건물을 카운트해가면 된다
 * Double.MIN_VALUE는 0값임에 주의. Double.NEGATIVE_INFINITY 을 써야함
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 고층_건물_골드4_1027 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static int getCount(int direction, int sIdx) {
        int count = 0;
        int sHeight = arr[sIdx];
        double angle = Double.NEGATIVE_INFINITY;

        int idx = sIdx;
        while (idx + direction >= 0 && idx + direction < arr.length) {
            idx += direction;
            double newAngle = ((double) arr[idx] - sHeight) / Math.abs(sIdx - idx);
            if (angle >= newAngle) {
                continue;
            }
            count++;
            angle = newAngle;
        }
        return count;
    }

    static void sol() throws IOException {
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            count += getCount(1, i);
            count += getCount(-1, i);
            maxCount = Math.max(maxCount, count);
        }
        bw.write(maxCount + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}