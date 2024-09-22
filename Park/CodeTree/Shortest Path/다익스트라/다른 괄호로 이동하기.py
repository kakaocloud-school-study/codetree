import heapq
import sys

INT_MAX = sys.maxsize  # 무한대 값으로 사용할 상수
MAX_M = 900  # 최대 정점 수

# 변수 선언 및 입력
n, a, b = map(int, input().split())  # n: 격자 크기, a: 같은 문자끼리의 비용, b: 다른 문자끼리의 비용 입력 받음
brackets = [[" "] * (n + 1) for _ in range(n + 1)]  # 격자를 저장할 2차원 리스트
for i in range(1, n + 1):
    brackets[i] = " " + input()  # 각 줄의 입력을 격자에 저장

m = 0  # 노드 번호를 매길 변수
node_num = [[0] * (n + 1) for _ in range(n + 1)]  # 각 격자의 위치에 노드 번호 부여
graph = [[] for _ in range(MAX_M + 1)]  # 그래프를 인접 리스트로 표현
pq = []  # 우선순위 큐를 사용한 다익스트라 알고리즘에 활용

dist = [0] * (MAX_M + 1)  # 각 노드에 대한 최단 거리
ans = 0  # 결과값을 저장할 변수


# 격자의 범위 내에 있는지 확인하는 함수
def in_range(x, y):
    return 1 <= x <= n and 1 <= y <= n


# 그래프를 구축하는 함수
def make_graph():
    global m

    # 각 칸에 순서대로 번호를 부여
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            m += 1
            node_num[i][j] = m  # 각 격자에 고유 번호를 부여
    
    # 인접한 칸들 간의 간선을 그래프에 추가
    for x in range(1, n + 1):
        for y in range(1, n + 1):
            # 상하좌우 이동을 위한 방향 설정
            dxs, dys = [-1, 1, 0, 0], [0, 0, 1, -1]

            for dx, dy in zip(dxs, dys):
                nx, ny = x + dx, y + dy
                if in_range(nx, ny):  # 격자 범위 내에 있는지 확인
                    node1 = node_num[x][y]
                    node2 = node_num[nx][ny]
                    # 같은 문자일 경우 a의 비용, 다른 문자일 경우 b의 비용 부여
                    cost = a if brackets[x][y] == brackets[nx][ny] else b
                    graph[node1].append((node2, cost))  # 인접 리스트에 간선 추가


# 다익스트라 알고리즘을 사용해 최단 거리를 구하는 함수
def dijkstra(k):
    # 모든 노드의 초기 거리를 무한대로 설정
    for i in range(1, m + 1):
        dist[i] = INT_MAX

    # 시작점의 거리는 0으로 설정
    dist[k] = 0

    # 우선순위 큐에 시작점을 삽입
    heapq.heappush(pq, (0, k))

    # 큐가 빌 때까지 반복
    while pq:
        min_dist, min_index = heapq.heappop(pq)  # 가장 가까운 정점을 꺼냄

        # 이미 처리된 노드는 스킵
        if min_dist != dist[min_index]:
            continue

        # 현재 정점과 연결된 간선들을 확인하여 최단 거리 갱신
        for target_index, target_dist in graph[min_index]:
            new_dist = dist[min_index] + target_dist
            if dist[target_index] > new_dist:
                dist[target_index] = new_dist
                heapq.heappush(pq, (new_dist, target_index))


# 그래프 구축
make_graph()

# 각 정점을 시작점으로 다익스트라를 수행하고, 최댓값을 갱신
for i in range(1, m + 1):
    dijkstra(i)

    # 각 도착지에 대한 최단 거리 중 최댓값을 찾음
    for j in range(1, m + 1):
        ans = max(ans, dist[j])

print(ans)
