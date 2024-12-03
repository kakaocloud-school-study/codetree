package lim.미분류;

import java.util.*;
import java.io.*;

public class 골드2_1918_후위_표기식 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word;

    static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    static void sol() throws IOException {
        StringBuilder result = new StringBuilder();

        HashMap<Character, Integer> orderByOp = new HashMap<>();
        orderByOp.put('*', 1);
        orderByOp.put('/', 1);
        orderByOp.put('+', 2);
        orderByOp.put('-', 2);

        LinkedList<Character> ops = new LinkedList<>();

        for (char ch : word.toCharArray()) {
            if (isUpperCase(ch)) {
                result.append(ch);
                continue;
            }

            if (ch == '(') {
                ops.offerLast(ch);
            } else if (ch == ')') {
                while (!ops.isEmpty()) {
                    char topOp = ops.pollLast();
                    if (topOp == '(') {
                        break;
                    }
                    result.append(topOp);
                }
            } else {
                while (!ops.isEmpty() && ops.getLast() != '(' && orderByOp.get(ops.getLast()) <= orderByOp.get(ch)) {
                    char topOp = ops.pollLast();
                    result.append(topOp);
                }
                ops.offerLast(ch);
            }
        }

        while (!ops.isEmpty()) {
            char topOp = ops.pollLast();
            result.append(topOp);
        }

        bw.write(result.toString() + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        word = st.nextToken();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}