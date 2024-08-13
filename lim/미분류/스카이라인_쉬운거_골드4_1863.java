package lim.미분류;

import java.util.*;
import java.io.*;

public class 스카이라인_쉬운거_골드4_1863 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] lines;

    static void sol() throws IOException {

        ArrayList<Integer> stack = new ArrayList<>();
        int count = 0;

        for (int[] line : lines) {
            int y = line[1];
            while (!stack.isEmpty() && stack.get(stack.size() - 1) > y) {
                stack.remove(stack.size() - 1);
                count++;
            }
            if (y == 0) {
                continue;
            }
            if (stack.isEmpty() || stack.get(stack.size() - 1) != y) {
                stack.add(y);
            }
        }
        count += stack.size();

        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}