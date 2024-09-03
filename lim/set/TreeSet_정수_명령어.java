package lim.set;

import java.util.*;
import java.io.*;

public class TreeSet_정수_명령어 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String[] cmds;
    static int[] values;

    static void sol() throws IOException {
        TreeSet<Integer> nums = new TreeSet<>();

        for (int i = 0; i < cmds.length; i++) {
            String cmd = cmds[i];
            int value = values[i];
            if (cmd.equals("I")) {
                nums.add(value);
            } else if (cmd.equals("D") && value == 1) {
                nums.pollLast();
            } else if (cmd.equals("D") && value == -1) {
                nums.pollFirst();
            }
        }
        if (nums.isEmpty()) {
            bw.write("EMPTY\n");
            return;
        }
        bw.write(nums.last() + " " + nums.first() + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            cmds = new String[n];
            values = new int[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                cmds[j] = st.nextToken();
                values[j] = Integer.parseInt(st.nextToken());
            }
            sol();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}