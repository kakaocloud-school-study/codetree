package lim.미분류;

import java.util.*;
import java.io.*;

public class 집합_실버5_11723 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static BufferedReader br;
    static StringTokenizer st;

    static void sol() throws IOException {
        HashSet<String> values = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            String operand = "";
            if (!operator.equals("all") && !operator.equals("empty")) {
                operand = st.nextToken();
            }

            if (operator.equals("add")) {
                values.add(operand);
            } else if (operator.equals("remove")) {
                values.remove(operand);
            } else if (operator.equals("check")) {
                if (values.contains(operand)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (operator.equals("toggle")) {
                if (values.contains(operand)) {
                    values.remove(operand);
                } else {
                    values.add(operand);
                }
            } else if (operator.equals("all")) {
                for (int num = 1; num < 21; num++) {
                    values.add(String.valueOf(num));
                }
            } else if (operator.equals("empty")) {
                values.clear();
            }
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        sol();
        br.close();
    }
}
