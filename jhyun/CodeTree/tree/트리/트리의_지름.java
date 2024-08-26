import java.util.*;
import java.io.*;

class Pair {
    int num, dist;

    public Pair(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}
public class Main {
    static final int MAX_N = 100_000;

    static int n;
    static List<Pair>[] edges = new ArrayList[MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];

    static void dfs(int x, int totalDist){
        for(int i = 0; i < edges[x].size(); i++){
            int y = edges[x].get(i).num;
            int d = edges[x].get(i).dist;

            if(!visited[y]){
                visited[y] = true;
                dist[y] = totalDist + d;
                dfs(y, totalDist + d);
            }
        }
    }

    // 정점 x로부터 가장 멀리 있는 정점 정보
    static Pair FindLargestVertex(int x){
        for(int i = 1; i <= n; i++){
            visited[i] = false;
            dist[i] = 0;
        }

        visited[x] =true;
        dist[x] = 0;
        dfs(x,0);

        int farthestDist = -1;
        int farthestVertex = -1;
        for(int i = 1; i <= n; i++){
            if(dist[i] > farthestDist){
                farthestDist = dist[i];
                farthestVertex = i;
            }
        }

        return new Pair(farthestVertex, farthestDist);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            edges[x].add(new Pair(y, d));
            edges[y].add(new Pair(x, d));
        }

        // 1번 정점으로부터 가장 멀리 있는 정점 정보
        int fVertex = FindLargestVertex(1).num;
        // farthest vertex로부터 가장 멀리 있는 정점 정보
        int diameter = FindLargestVertex(fVertex).dist;

        System.out.print(diameter);
    }
}