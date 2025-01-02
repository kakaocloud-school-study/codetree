package lim.미분류;

import java.io.*;
import java.util.ArrayList;

public class 골드5_5430_AC {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String cmd;
    static int[] arr;

    static void sol() throws IOException {
        int[] idxs = new int[] { 0, arr.length - 1 }, dxs = new int[] { 1, -1 };
        int dir = 0;
        for (char ch : cmd.toCharArray()) {
            if (ch == 'R') {
                dir ^= 1;
            } else {
                if (idxs[0] > idxs[1]) {
                    bw.write("error\n");
                    return;
                }
                idxs[dir] += dxs[dir];
            }
        }

        ArrayList<String> result = new ArrayList<>();
        while (idxs[0] <= idxs[1]) {
            int idx = idxs[dir];
            result.add(String.valueOf(arr[idx]));
            idxs[dir] += dxs[dir];
        }
        bw.write("[" + String.join(",", result) + "]\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            cmd = br.readLine();
            br.readLine();
            String line = br.readLine();
            line = line.substring(1, line.length() - 1);
            String[] values;
            if (line.isBlank()) {
                values = new String[0];
            } else {
                values = line.split(",");
            }
            arr = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                arr[i] = Integer.parseInt(values[i]);
            }
            sol();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
