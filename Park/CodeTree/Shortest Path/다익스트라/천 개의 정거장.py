INF = (10**17) + 1

# 변수 선언 및 입력:
m = 1000  # 서로 다른 정점의 수
a, b, n = map(int, input().split())  # 시작점(a), 도착점(b), 경로 수(n) 입력 받음
graph = [[(INF, 0)] * (m + 1) for _ in range(m + 1)]  # 각 정점 간 비용과 시간을 저장하는 인접 행렬
dist = [(INF, 0)] * (m + 1)  # 최단 경로를 기록 (비용, 시간)
visited = [False] * (m + 1)  # 방문 여부를 기록하는 배열

# 자기 자신으로 가는 경로의 비용과 시간은 0
for i in range(1, m + 1):
    graph[i][i] = (0, 0)

# 경로 입력 및 인접 행렬 업데이트
for _ in range(n):
    cost, stop_num = map(int, input().split())  # 각 경로의 비용과 정차 지점 수
    stops = list(map(int, input().split()))  # 경로의 정차 지점들

    # 각 정차 지점 사이의 비용과 시간을 업데이트
    for i in range(stop_num):
        for j in range(i + 1, stop_num):
            graph[stops[i]][stops[j]] = min(graph[stops[i]][stops[j]], (cost, j - i))

# 시작 지점의 비용과 시간을 0으로 설정
dist[a] = (0, 0)

# 다익스트라 알고리즘
for _ in range(m):
    # 방문하지 않은 정점 중에서 가장 비용이 작은 정점을 선택
    min_index = -1
    for i in range(1, m + 1):
        if not visited[i] and (min_index == -1 or dist[i] < dist[min_index]):
            min_index = i

    # 선택된 정점 방문 처리
    visited[min_index] = True
    min_cost, min_time = dist[min_index]

    # 선택된 정점과 연결된 다른 정점들의 최단 경로 갱신
    for i in range(1, m + 1):
        cost, time = graph[min_index][i]
        if dist[i] > (min_cost + cost, min_time + time):
            dist[i] = (min_cost + cost, min_time + time)

# 목적지에 도달할 수 없는 경우 -1, -1 출력
if dist[b] == (INF, 0):
    print(-1, -1)
else:
    min_cost, min_time = dist[b]
    print(min_cost, min_time)
