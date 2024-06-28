import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;
    static int[] arr = new int[MAX_N + 1];

    static int n, m;

    static int lowerBound(int target) {
        int left = 1, right = n;
        int minIdx = n + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            int query = Integer.parseInt(st.nextToken());

            int low = lowerBound(query);
            if (low <= n && arr[low] == query) {
                System.out.println(low);
            } else {
                System.out.println(-1);
            }
        }

    }
}