import sys
import heapq

# 무한대를 의미하는 큰 수를 설정
INT_MAX = sys.maxsize

# 입력 처리
n, m = map(int, input().split())  # 노드 개수와 간선 개수 입력
a, b = map(int, input().split())  # 빨간점 1(a), 빨간점 2(b) 입력

# 그래프 초기화 (인접 리스트로 표현)
graph = [[] for _ in range(n + 1)]

# 초기 거리 배열 (빨간점 1, 2에 대한 거리)
red_dist1 = [INT_MAX] * (n + 1)
red_dist2 = [INT_MAX] * (n + 1)

# 최솟값을 저장할 변수
answer = INT_MAX

# 양방향 그래프 입력 받기
for _ in range(m):
    x, y, z = map(int, input().split())
    graph[x].append((y, z))
    graph[y].append((x, z))

# 다익스트라 알고리즘 함수 정의
def dijkstra(start, dist):
    # 우선순위 큐와 시작점 거리 초기화
    pq = []
    heapq.heappush(pq, (0, start))  # (거리, 정점)
    dist[start] = 0  # 시작점의 거리는 0

    # 우선순위 큐가 비어있지 않으면 계속 탐색
    while pq:
        current_dist, current_node = heapq.heappop(pq)

        # 이미 처리된 노드라면 패스
        if current_dist > dist[current_node]:
            continue

        # 현재 노드와 연결된 다른 노드들 탐색
        for next_node, weight in graph[current_node]:
            new_dist = current_dist + weight
            if new_dist < dist[next_node]:
                dist[next_node] = new_dist
                heapq.heappush(pq, (new_dist, next_node))

# 빨간점 1(a)에서 시작하는 최단 경로 탐색
dijkstra(a, red_dist1)

# 빨간점 2(b)에서 시작하는 최단 경로 탐색
dijkstra(b, red_dist2)

# 검정점에서 시작해 빨간점 1, 2를 순회하는 경로 중 최솟값 찾기
for i in range(1, n + 1):
    # 검정점이 빨간점 1(a)나 빨간점 2(b)라면 패스
    if i == a or i == b:
        continue

    # 검정점 -> 빨간점 1 -> 빨간점 2 -> 검정점 경로
    route1 = red_dist1[i] + red_dist1[b] + red_dist2[i]
    # 검정점 -> 빨간점 2 -> 빨간점 1 -> 검정점 경로
    route2 = red_dist2[i] + red_dist2[a] + red_dist1[i]

    # 두 경로 중 더 작은 값을 선택
    answer = min(answer, route1, route2)

# 최종 결과 출력 (불가능한 경우 -1)
if answer == INT_MAX:
    print(-1)
else:
    print(answer)
