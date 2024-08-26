package CodingTest.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수
        int[] x = new int[M]; // 가로등 위치
        int result = 0; // 최소 높이

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int point = Integer.parseInt(st.nextToken());
            x[i] = point;
        }

        int low = 1;
        int high = N;
        while(low <= high) {
            int mid = (low+high)/2;
            boolean flag = true;

            // mid 높이로 가능한지 굴다리를 쭉 돌아본다
            int point = 0; // 이전에 가로등이 비추었던 위치
            for (int i=0; i<x.length; i++) {
                if (x[i] - mid <= point) {
                    point = x[i] + mid; // 가로등은 x[i]+mid까지 비출 수 있다.
                }
                else {
                    flag = false;
                }
            }

            if (N - point > 0) {
                flag = false;
            }
            else {
                flag = true;
            }

            if (flag) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }
}