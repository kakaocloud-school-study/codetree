import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;

    static int n;
    static int ans;
    static int[] arr = new int[MAX_N];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        while (pq.size() > 1) {
            int x1 = pq.poll();
            int x2 = pq.poll();

            ans += (x1 + x2);
            pq.add(x1 + x2);
        }
        System.out.print(ans);
    }
}