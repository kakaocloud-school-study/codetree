import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 10000;

    static int n;
    static int root;
    static int[] deg = new int[MAX_N  +1];
    static List<Integer>[] edges = new ArrayList[MAX_N + 1];
    static boolean[] used = new boolean[MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];
    static boolean isTree = true;

    static void dfs(int x){
        for(int i = 0; i < edges[x].size(); i++){
            int y = edges[x].get(i);
            if(visited[y]){
                continue;
            }
            visited[y] = true;
            dfs(y);
        }

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= MAX_N; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i =1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //간선 정보를 인접리스트에 넣기
            edges[x].add(y);

            //해당 번호가 그래프에 있는 정점 번호인지 판단
            used[x] = used[y] = true;

            //정점 별 들어오는 간선의 개수 저장
            deg[y]++;
        }

        // 루트 노드를 찾기. 들어오는 간선이 하나도 없는 노드가 여러개면 트리가 아님
        for(int i = 1; i <= MAX_N; i++){
            if(used[i] && deg[i] == 0){
                //이미 선정된 루트가 있다면 루트가 여러 개인 것이므로 트리가 아님
                if(root != 0){
                    isTree = false;
                }
                root = i;
            }
        }

        if(root == 0){
            isTree = true;
        }

        //루트 노드를 제외한 노드는 모두 들어오는 간선이 1개씩 있음
        for(int i = 1; i <= MAX_N; i++){
            if(used[i] && i != root && deg[i] != 1){
                isTree = false;
            }
        }

        if(isTree && root != 0){
            //root 정점으로부터 모든 정점을 갈 수 있는지 판단
            visited[root] = true;
            dfs(root);
        }

        //root 정점으로부터 탐색해 도달하지 못하는 정점이 있으면 트리가 아님
        for(int i = 1; i <= MAX_N; i++){
            if(used[i] && !visited[i]){
                isTree = false;
            }
        }

        if(isTree){
            System.out.print(1);
        }else{
            System.out.print(0);
        }
    }
}