package lim.스택큐;

import java.util.*;
import java.io.*;

public class 실버4_4949_균형잡힌_세상 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<String> lines = new ArrayList<>();

    static boolean check(String line) {
        Stack<Character> stack = new Stack<>();
        for (char ch : line.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (!stack.isEmpty() && (ch == ')' || ch == ']')) {
                if (((ch == ')' && stack.peek() == '(')) || (ch == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (stack.isEmpty() && (ch == ')' || ch == ']')) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    static void sol() throws IOException {
        for (String line : lines) {
            bw.write(check(line) ? "yes\n" : "no\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            lines.add(line);
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
