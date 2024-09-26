import sys

# 최대 거리를 나타내는 상수
INF = sys.maxsize

# 노드 개수, 간선 개수 입력
n, m = map(int, input().split())
# 시작 정점, 도착 정점, 목표 정점 입력
start1, start2, target = map(int, input().split())

# 거리를 표현하는 인접행렬을 무한대로 초기화
dist = [[INF] * (n + 1) for _ in range(n + 1)]

# 자기 자신으로 가는 거리는 0으로 설정
for i in range(1, n + 1):
    dist[i][i] = 0

# 간선 정보 입력 및 인접행렬에 값 채우기
for _ in range(m):
    node1, node2, weight = map(int, input().split())
    dist[node1][node2] = dist[node2][node1] = weight

# 플로이드-워셜 알고리즘을 통해 모든 쌍 최단 거리 계산
for k in range(1, n + 1):  # 경유지 k
    for i in range(1, n + 1):  # 출발지 i
        for j in range(1, n + 1):  # 도착지 j
            # i에서 j로 가는 경로가 k를 경유하는 것이 더 짧은 경우 갱신
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

# 각 경유지 k를 거쳐서 start1과 start2가 만난 뒤 target으로 가는 최단 거리 계산
min_distance = INF
for meet_point in range(1, n + 1):
    min_distance = min(min_distance, dist[start1][meet_point] + dist[start2][meet_point] + dist[meet_point][target])

# 답이 갱신되지 않은 경우 -1로 설정
if min_distance == INF:
    min_distance = -1

# 결과 출력
print(min_distance)
