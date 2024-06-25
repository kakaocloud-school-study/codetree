import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;
    static int n;
    static int[] R = new int[MAX_N];
    static int[] dist = new int[MAX_N + 1];
    static int[] cost = new int[MAX_N + 1];
    static int[] minCost = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        //i번째 장소로 이제 출발할 때 기준으로 지금까지 왔던 장소 중
        //에너지 1을 채우는데 필요한 비용이 가장 작은 곳을 저장
        minCost[2] = cost[1];
        for (int i = 3; i <= n; i++) {
            minCost[i] = Math.min(minCost[i - 1], cost[i - 1]);
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += (long) minCost[i] * dist[i];
        }

        System.out.print(ans);
    }
}