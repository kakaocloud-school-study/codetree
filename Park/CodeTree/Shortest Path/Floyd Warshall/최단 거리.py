import sys

# 변수 선언 및 입력:
n, m = map(int, input().split())  # n: 노드의 수, m: 쿼리 수

# 그래프를 인접 행렬로 표현하고 거리 정보를 입력받음
graph = [
    list(map(int, input().split()))
    for _ in range(n)
]

# 플로이드-워셜 알고리즘을 통해 모든 쌍 간의 최단 경로 계산
for k in range(n):
    for i in range(n):
        for j in range(n):
            # k를 경유한 경로가 더 짧으면, 최단 거리 갱신
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

# m개의 질문에 대해 최단 경로를 출력
for _ in range(m):
    u, v = map(int, input().split())
    # 입력 노드는 1부터 시작하므로, 인덱스에 맞추기 위해 -1을 해줌
    print(graph[u - 1][v - 1])
