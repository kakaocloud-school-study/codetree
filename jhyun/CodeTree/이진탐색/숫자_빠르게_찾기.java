import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;

    static int n, m;
    static int[] arr = new int[MAX_N];

    static int find(int target) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());

            int idx = find(x);

            if (idx >= 0) {
                System.out.println(idx + 1);
            } else {
                System.out.println(-1);
            }
        }


    }
}