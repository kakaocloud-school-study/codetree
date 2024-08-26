package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11723 {
    static int m;
    static StringBuilder sb = new StringBuilder();
    static int bitMask = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("empty") || cmd.equals("all")) {
                func(cmd);
                continue;
            }
            int x = Integer.parseInt(st.nextToken());
            func(cmd, x);
        }
        System.out.println(sb.toString());
    }

    public static void func(String cmd) {
        if(cmd.equals("all")) {
            bitMask = ~0;
        }
        if (cmd.equals("empty")) {
            bitMask = 0;
        }
    }

    public static void func(String cmd, int x) {
        if (cmd.equals("add")) {
            bitMask =bitMask | 1 << (x-1);
        }
        if(cmd.equals("remove")) {
            bitMask = bitMask & ~(1 << (x - 1));
        }
        if(cmd.equals("check")) {
            sb.append(((bitMask & 1 << (x-1)) == 1 << (x-1) ? 1 : 0) + "\n");
        }
        if(cmd.equals("toggle")) {
            bitMask = bitMask ^ 1 << (x-1);
        }
    }
}
