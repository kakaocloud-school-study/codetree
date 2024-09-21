import sys

INT_MAX = sys.maxsize  # 아주 큰 값을 나타냄.

# 변수 선언 및 입력
n, m = map(int, input().split())  # n은 정점의 수, m은 간선의 수
graph = [[0] * (n + 1) for _ in range(n + 1)]  # 인접 행렬로 그래프 표현
visited = [False] * (n + 1)  # 각 정점의 방문 여부를 저장

# 각 정점까지의 최단거리를 나타내는 배열을 아주 큰 값으로 초기화
dist = [INT_MAX] * (n + 1)  

# 그래프를 인접 행렬로 입력 받기.
for _ in range(m):
    x, y, z = map(int, input().split())  # x에서 y로 가는 가중치 z의 간선
    graph[x][y] = z  # 간선을 인접 행렬에 기록

# 시작점(1번 정점)의 거리를 0으로 설정
dist[1] = 0

# 다익스트라 알고리즘 구현
for i in range(1, n + 1):
    # 방문하지 않은 정점 중 최단 거리가 가장 작은 정점을 찾기.
    min_index = -1
    for j in range(1, n + 1):
        if not visited[j] and (min_index == -1 or dist[min_index] > dist[j]):
            min_index = j

    # 해당 정점을 방문 처리
    visited[min_index] = True

    # 선택된 정점과 연결된 다른 정점들의 거리 갱신
    for j in range(1, n + 1):
        if graph[min_index][j] != 0:  # 간선이 존재할 때만
            dist[j] = min(dist[j], dist[min_index] + graph[min_index][j])

# 결과 출력: 1번 정점에서 각 정점까지의 최단거리를 출력.
for i in range(2, n + 1):
    if dist[i] == INT_MAX:
        print(-1)  # 도달할 수 없는 경우
    else:
        print(dist[i])  # 최단 거리 출력
