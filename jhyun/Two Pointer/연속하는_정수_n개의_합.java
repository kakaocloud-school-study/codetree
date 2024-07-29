import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;
    static int[] arr = new int[MAX_N + 1];

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        int sumVal = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            //구간 내 합이 m보다 작으면 계속 진행
            while (j + 1 <= n && sumVal < m) {
                sumVal += arr[j + 1];
                j++;
            }

            //구간 내 합이 m이 되면 ans++
            if (sumVal == m) {
                ans++;
            }

            //다음 구간으로 넘어가기 전, arr[i]에 해당하는 값은 구간에서 제외
            sumVal -= arr[i];
        }
        System.out.print(ans);
    }
}