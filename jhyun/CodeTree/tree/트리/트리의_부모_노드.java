import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100_000;
    static int n;
    static List<Integer>[] edges = new ArrayList[MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];
    static int[] parent = new int[MAX_N + 1];

    static void traversal(int x){
        for(int i = 0; i < edges[x].size(); i++){
            int y = edges[x].get(i);

            if(!visited[y]){
                visited[y] = true;
                parent[y] = x;
                traversal(y);
            }
        }
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

            edges[x].add(y);
            edges[y].add(x);
        }

        visited[1] = true;
        traversal(1);

        for(int i = 2; i <= n; i++){
            System.out.println(parent[i]);
        }

    }
}