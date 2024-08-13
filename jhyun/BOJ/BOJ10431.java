package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10431 {
    static int tc;
    static int[] length;
    static int testNum, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < tc; testCase++) {
            init(br);

            for (int i = 1; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (length[j] > length[i]) {
                        int temp = length[i];

                        for (int k = i; k > j; k--) {
                            length[k] = length[k - 1];
                            ans++;
                        }
                        length[j] = temp;
                        break;
                    }
                }
            }

            System.out.println(testNum + " " + ans);
        }
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        testNum = Integer.parseInt(st.nextToken());
        ans = 0;

        length = new int[20];
        for (int i = 0; i < 20; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }
    }
}