import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100;
    static int n, m;
    static int[][] dist = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = (int) 1e9;
            }

            //자기 자신으로 가는 값은 0으로 설정
            dist[i][i] = 0;
        }

        //그래프를 인접행렬로 표현
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            //x -> y 간선이 여러 개 주어질 수도 있다고 하였으므로 최솟값을 계속 갱신
            dist[x][y] = Math.min(dist[x][y], z);
        }

        for (int k = 1; k <= n; k++) { //확실하게 거쳐갈 정점을 1번부터 N번까지 순서대로 정의
            for (int i = 1; i <= n; i++) { //고정된 k에 대해 모든 쌍 (i,j)
                for (int j = 1; j <= n; j++) {
                    //i에서 j로 가는 거리가 k를 경유해 가는 것이 더 좋다면 dist[i][j]값을 갱신
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        //모든 쌍에 대한 최단거리 결과 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //불가능한 경우 : -1
                if (dist[i][j] == (int) 1e9) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}