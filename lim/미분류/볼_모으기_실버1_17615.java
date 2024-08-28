/*
 * 문자가 두개니까 두 경우의 수로 나눈다
 * 특정 문자만을 옮길 때 연산횟수 최소를 구하는 함수를 선언
 * 양끝 중에 타겟 문자가 많이 모인 끝에 떨어진 나머지 타겟을 옮긴다
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 볼_모으기_실버1_17615 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String line;

    static int getCost(char target) {
        int left = 0, right = line.length() - 1;
        int leftCount = 0;
        while (left < line.length() && line.charAt(left) == target) {
            left++;
            leftCount++;
        }
        int rightCount = 0;
        while (right >= 0 && line.charAt(right) == target) {
            right--;
            rightCount++;
        }

        int ops = 0;
        if (leftCount >= rightCount) {
            for (int i = left; i < line.length(); i++) {
                if (target == line.charAt(i)) {
                    ops++;
                }
            }
        } else {
            for (int i = right; i >= 0; i--) {
                if (target == line.charAt(i)) {
                    ops++;
                }
            }
        }
        return ops;
    }

    static void sol() throws IOException {
        bw.write(Math.min(getCost('R'), getCost('B')) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        line = br.readLine();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}