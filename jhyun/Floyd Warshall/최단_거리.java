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

        //그래프를 인접행렬로 표현
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1; k <= n; k++) { //확실하게 거쳐갈 정점을 1번부터 N번까지 순서대로 정의
            for (int i = 1; i <= n; i++) { //고정된 k에 대해 모든 쌍 (i,j)
                for (int j = 1; j <= n; j++) {
                    //i에서 j로 가는 거리가 k를 경유해 가는 것이 더 좋다면 dist[i][j]값을 갱신
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        //m개의 질문에 대해 최단 거리를 답변
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //모든 쌍에 대한 최단거리 결과를 가지고 있기 때문에, 어느 경로를 질문하더라도 바로 최단거리를 출력
            System.out.println(dist[x][y]);
        }
    }
}