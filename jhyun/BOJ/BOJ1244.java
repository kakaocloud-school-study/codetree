package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {
    static int n;
    static boolean[] switches;
    static int number, num;
    static int gender;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        switches = new boolean[n];
        for (int i = 0; i < n; i++) {
            switches[i] = st.nextToken().equals("1");
        }
        number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken()) - 1; // Convert to 0-based index

            if (gender == 1) { // Male student
                for (int j = num; j < n; j += (num + 1)) {
                    switches[j] = !switches[j];
                }
            } else if (gender == 2) { // Female student
                switches[num] = !switches[num];
                int idx = 1;
                while (num - idx >= 0 && num + idx < n && switches[num - idx] == switches[num + idx]) {
                    switches[num - idx] = !switches[num - idx];
                    switches[num + idx] = !switches[num + idx];
                    ++idx;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (switches[i]) sb.append("1");
            else sb.append("0");
            sb.append(" ");

            if (i % 20 == 19) sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}