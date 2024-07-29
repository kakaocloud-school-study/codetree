import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_K = 4;
    static final int MAX_N = 12;

    static int n, m, k;
    static int[] nums = new int[MAX_N];
    static int[] pieces = new int[MAX_K];
    static int ans;

    static int calc() {
        int score = 0;
        for (int i = 0; i < k; i++) {
            score += (pieces[i] >= m ? 1 : 0);
        }
        return score;
    }

    static void findMax(int cnt) {
        ans = Math.max(ans, calc());
        if (cnt == n) {
            return;
        }

        for (int i = 0; i < k; i++) {
            if (pieces[i] >= m) {
                continue;
            }

            pieces[i] += nums[cnt];
            findMax(cnt + 1);
            pieces[i] -= nums[cnt];
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            pieces[i] = 1;
        }

        findMax(0);

        System.out.print(ans);
    }
}