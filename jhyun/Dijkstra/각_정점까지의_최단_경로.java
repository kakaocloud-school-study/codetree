import java.util.*;
import java.io.*;

class Node {
    int index, dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
};

class Element implements Comparable<Element> {
    int dist, index;

    public Element(int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    //dist 기준 오르차순
    @Override
    public int compareTo(Element e) {
        return this.dist - e.dist;
    }
};

public class Main {
    static final int MAX_N = 20000;
    static int n, m, k;
    static List<Node>[] graph = new ArrayList[MAX_N + 1];
    static PriorityQueue<Element> pq = new PriorityQueue<>();

    static int[] dist = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine());

        //그래프를 인접리스트로 표현
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        //양방향 그래프이므로 양쪽에 추가
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }

        //그래프에 있는 모든 노드들에 대해 초기값을 전부 아주 큰 값으로 설정
        //INT_MAX 그 자체로 설정하면 후에 덧셈 진행시 overflow 발생할 수 있으므로 적당히 큰 숫자로 적기
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
        }

        dist[k] = 0;

        //우선순위 큐에 시작점을 넣기
        //거리가 가까운 곳이 먼저 나와야 하며 해당 지점이 어디인지에 대한 정보도 필요하므로
        //(거리, 정점 번호) 형태로 넣어주기
        pq.add(new Element(0, k));

        //O(|E|log|V|) 다익스트라 코드
        //우선순위 큐에 원소가 남아있다면 계속 진행
        while (!pq.isEmpty()) {
            //가장 거리가 가까운 정보를 받아온 뒤, 원소 제거
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            //우선순위 큐를 이용하면 같은 정점의 원소가 여러 번 들어가는 문제 발생
            //minDist가 최신 dist[minIndex]값과 다르다면 계산할 필요없이 패스
            if (minDist != dist[minIndex]) {
                continue;
            }

            //최솟값에 해당하는 정점에 연결된 간선들을 보며 시작점으로부터 최단거리 값 갱신
            for (int j = 0; j < graph[minIndex].size(); j++) {
                int targetIndex = graph[minIndex].get(j).index;
                int targetDist = graph[minIndex].get(j).dist;

                //현재 위치에서 연결된 간선으로 가는 것이 더 작다면
                int newDist = dist[minIndex] + targetDist;
                if (dist[targetIndex] > newDist) {
                    //값 갱신, 우선순위 큐에 해당 정보를 넣기
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        //시작점(k번 정점)으로부터 각 지점까지의 최단거리 값 출력
        for (int i = 1; i <= n; i++) {
            //도달 불가능 : -1
            if (dist[i] == (int) 1e9) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}