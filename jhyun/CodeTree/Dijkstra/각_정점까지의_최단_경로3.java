import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100;
    static int n, m;
    static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x][y] = z;
        }

        //그래프에 있는 모든 노드들에 대해 초기값을 전부 아주 큰 값으로 설정
        //INT_MAX 그 자체로 설정하면 후에 덧셈 진행시 overflow가 발생할 수도 있으니
        //적당히 큰 숫자로 적어줘아함!
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
        }

        //시작위치에는 dist값을  0으로 설정
        dist[1] = 0;

        //O(|V|^2) 다익스트라 코드
        for (int i = 1; i <= n; i++) {
            //V개의 정점 중 아직 방문하지 않은 정점 중
            //dist값이 가장 작은 정점을 찾아줌
            int minIndex = -1;
            for (int j = 1; j <= n; j++) {
                if (visited[j]) {
                    continue;
                }
                if (minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            //최솟값에 해당하는 정점에 방문 표시 진행
            visited[minIndex] = true;

            //최솟값에 해당하는 정점에 연결된 간선들을 보며 시작점으로부터의 최단거리 값을 갱신
            for (int j = 1; j <= n; j++) {
                //간선이 존재하지 않는 경우에는 넘어감
                if (graph[minIndex][j] == 0) {
                    continue;
                }
                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }

        //시작점(1번 정점)으로부터 각 지점까지의 최단거리 값을 출력
        for (int i = 2; i <= n; i++) {
            //만약 도달이 불가능하다면 -1
            if (dist[i] == (int) 1e9) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}