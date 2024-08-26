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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        int max = sum;
        int maxCnt = 1;
        for (int i = x; i < n; i++) {
            sum += arr[i] - arr[i-x];
            if (max == sum) {
                maxCnt++;
            }
            else if (max < sum) {
                max = sum;
                maxCnt = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(maxCnt);
    }
}