package lim.스택큐;

import java.util.*;
import java.io.*;

public class 실버4_10845_큐 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] queries;

    static void sol() throws IOException {
        LinkedList<String> stack = new LinkedList<>();
        for (String[] query : queries) {
            if (query[0].equals("pop")) {
                bw.write((stack.isEmpty() ? -1 : stack.pollFirst()) + "\n");
            } else if (query[0].equals("push")) {
                stack.offerLast(query[1]);
            } else if (query[0].equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (query[0].equals("empty")) {
                bw.write((stack.isEmpty() ? 1 : 0) + "\n");
            } else if (query[0].equals("front")) {
                bw.write((stack.isEmpty() ? -1 : stack.peekFirst()) + "\n");
            } else if (query[0].equals("back")) {
                bw.write((stack.isEmpty() ? -1 : stack.peekLast()) + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queries = new String[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queries[i][0] = st.nextToken();
            if (queries[i][0].equals("push")) {
                queries[i][1] = st.nextToken();
            }
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
