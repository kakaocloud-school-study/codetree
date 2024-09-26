import sys

# 최대값 설정
INT_MAX = sys.maxsize

# 변수 선언 및 입력
n, m, p, q = map(int, input().split())  # n: 노드 수, m: 간선 수, p: 빨간 점 개수, q: 쿼리 개수

# 인접 행렬을 아주 큰 값으로 초기화
dist = [[INT_MAX] * (n + 1) for _ in range(n + 1)]

# 자기 자신으로 가는 거리는 0으로 설정
for i in range(1, n + 1):
    dist[i][i] = 0

# 간선 정보 입력받기
for _ in range(m):
    x, y, z = map(int, input().split())
    dist[x][y] = z  # x에서 y로 가는 가중치가 z

# 플로이드-워셜 알고리즘 적용: 모든 쌍의 최단 경로 계산
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

# 최종 결과 계산을 위한 변수
total_distance = 0  # 최단 거리들의 합
valid_count = 0     # 유효한 경로의 개수

# q개의 질문에 대해 처리
for _ in range(q):
    start, end = map(int, input().split())  # 쿼리에서 시작점과 끝점 입력

    # 빨간 점을 경유하는 경로 중 최단 경로를 찾음
    shortest_distance = INT_MAX
    for i in range(1, p + 1):
        # 빨간 점을 경유한 경로를 계산하고 최단 거리 갱신
        shortest_distance = min(shortest_distance, dist[start][i] + dist[i][end])

    # 경로가 존재하는 경우 (INT_MAX 값이 아닌 경우)만 결과에 반영
    if shortest_distance < INT_MAX:
        total_distance += shortest_distance
        valid_count += 1

# 결과 출력
print(valid_count)  # 유효한 경로의 개수 출력
print(total_distance)  # 최단 거리의 합 출력
