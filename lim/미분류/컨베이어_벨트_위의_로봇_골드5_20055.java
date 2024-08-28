/*
 * 컨베이어를 큐로 구현하고
 * 조건대로 잘 구현하면 됨
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 컨베이어_벨트_위의_로봇_골드5_20055 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<BUnit> units = new LinkedList<>();
    static int n, k, t = 0;

    static class BUnit {
        int beltNum, count;
        boolean hasRobot = false;

        BUnit(int beltNum, int count) {
            this.beltNum = beltNum;
            this.count = count;
        }
    }

    static void sol() throws IOException {
        int breakCount = 0;
        while (breakCount < k) {
            t++;
            // 1단계
            BUnit upUnit = units.pollLast();
            upUnit.hasRobot = false;
            units.offerFirst(upUnit);

            // 2단계
            ListIterator<BUnit> it = units.listIterator(n - 1);
            BUnit nextUnit = it.next();
            nextUnit.hasRobot = false; // 내리는 자리에 로봇 치움
            it.previous();
            while (it.hasPrevious()) {
                BUnit unit = it.previous();
                if (!unit.hasRobot) {
                    nextUnit = unit;
                    continue;
                }
                if (!nextUnit.hasRobot && nextUnit.count > 0) {
                    unit.hasRobot = false;
                    nextUnit.hasRobot = true;
                    nextUnit.count--;
                    if (nextUnit.count == 0) {
                        breakCount++;
                    }
                }
                nextUnit = unit;
            }

            // 3단계
            if (upUnit.count > 0) {
                upUnit.hasRobot = true;
                upUnit.count--;
                if (upUnit.count == 0) {
                    breakCount++;
                }
            }
        }
        bw.write(t + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            int count = Integer.parseInt(st.nextToken());
            units.offerLast(new BUnit(i, count));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}