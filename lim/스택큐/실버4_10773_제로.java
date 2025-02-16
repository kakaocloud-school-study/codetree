package lim.스택큐;

import java.util.*;
import java.io.*;

public class 실버4_10773_제로 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

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
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (num == 0) {
                stack.pop();
            } else {
                stack.add(num);
            }
        }
        int sum = 0;
        for (int num : stack) {
            sum += num;
        }
        bw.write(sum + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
