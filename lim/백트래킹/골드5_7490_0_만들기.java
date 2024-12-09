package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 골드5_7490_0_만들기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static int cal(ArrayList<Character> ops) {
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<Character> opStack = new LinkedList<>();

        numStack.offerLast(1);
        for (int num = 2; num < n + 1; num++) {
            int opIdx = num - 2;
            if (ops.get(opIdx) == ' ') {
                int prevNum = numStack.pollLast();
                numStack.offerLast(10 * prevNum + num);
            } else {
                numStack.offerLast(num);
                opStack.offerLast(ops.get(opIdx));
            }
        }

        int total = numStack.pollFirst();
        while (!numStack.isEmpty()) {
            int value = numStack.pollFirst();
            char op = opStack.pollFirst();
            if (op == '+') {
                total += value;
            } else if (op == '-') {
                total -= value;
            }
        }

        return total;
    }

    static void print(ArrayList<Character> ops) throws IOException {
        bw.write("1");
        for (int i = 0; i < ops.size(); i++) {
            bw.write(ops.get(i) + "" + (i + 2));
        }
        bw.write("\n");
    }

    static void func(ArrayList<Character> ops) throws IOException {
        if (ops.size() == n - 1) {
            if (cal(ops) == 0) {
                print(ops);
            }
            return;
        }

        for (char op : " +-".toCharArray()) {
            ops.add(op);
            func(ops);
            ops.remove(ops.size() - 1);
        }
    }

    static void sol() throws IOException {
        func(new ArrayList<>());
        bw.write("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            sol();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
