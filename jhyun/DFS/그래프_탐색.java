import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 1000;
    static int n, m;

    static List<Integer>[] graph = new ArrayList[MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];
    static int vertexCnt = 0;

    static void DFS(int vertex) {
        for (int i = 0; i < graph[vertex].size(); i++) {
            int currV = graph[vertex].get(i);
            if (!visited[currV]) {
                visited[currV] = true;
                vertexCnt++;
                DFS(currV);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        visited[1] = true;
        DFS(1);

        System.out.println(vertexCnt);
    }
}