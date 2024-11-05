/*
 * 오일러 피 함수
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 골드1_11689_GCD {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long n;

    static void sol() throws IOException {
        if (n == 1) {
            bw.write("1");
            return;
        }

        HashMap<Long, Integer> countByComponent = new HashMap<>();
        long currNum = n;
        for (long component = 2; component * component <= n; component++) {
            while (currNum % component == 0) {
                countByComponent.put(component, countByComponent.getOrDefault(component, 0) + 1);
                currNum /= component;
            }
        }
        if (currNum != 1) {
            countByComponent.put(currNum, countByComponent.getOrDefault(currNum, 0) + 1);
        }

        long total = 1;
        for (Map.Entry<Long, Integer> e : countByComponent.entrySet()) {
            long component = e.getKey();
            long count = e.getValue();
            total *= (component - 1) * Math.pow(component, count - 1);
        }
        if (countByComponent.size() == 0) {
            total = n - 1;
        }
        bw.write(total + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}