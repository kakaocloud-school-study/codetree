package lim.스택큐;

import java.util.*;
import java.io.*;

public class 실버4_9012_괄호 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] lines;

    static boolean check(String line) {
        Stack<Character> stack = new Stack<>();
        for (char ch : line.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    static void sol() throws IOException {
        for (String line : lines) {
            bw.write(check(line) ? "YES\n" : "NO\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        lines = new String[n];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = br.readLine();
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
