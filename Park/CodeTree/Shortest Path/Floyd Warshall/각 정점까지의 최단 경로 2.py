import sys

# 아주 큰 값으로 간주되는 무한대 값 설정
INT_MAX = sys.maxsize

# 입력 처리
n, m = map(int, input().split())  # 노드 개수와 간선 개수 입력

# 거리 배열 초기화: 모든 거리를 무한대로 설정
dist = [[INT_MAX] * (n + 1) for _ in range(n + 1)]

# 자기 자신으로 가는 거리는 0으로 초기화
for i in range(1, n + 1):
    dist[i][i] = 0

# 간선 정보 입력 받기 및 거리 갱신 (인접 행렬로 표현)   
for _ in range(m):
    x, y, z = map(int, input().split())
    # 동일한 x -> y 간선이 여러 번 주어질 수 있으므로 최소값을 유지
    dist[x][y] = min(dist[x][y], z)

# 플로이드-워셜 알고리즘 실행
for k in range(1, n + 1):  # 경유 노드 k
    for i in range(1, n + 1):  # 출발 노드 i
        for j in range(1, n + 1):  # 도착 노드 j
            # i -> j로 가는 최단거리가 i -> k -> j로 가는 경로보다 큰지 확인하고 갱신
            if dist[i][k] != INT_MAX and dist[k][j] != INT_MAX:
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

# 최종 결과 출력: 모든 쌍에 대한 최단 거리
for i in range(1, n + 1):
    for j in range(1, n + 1):
        # 도달할 수 없는 경우에는 -1 출력
        if dist[i][j] == INT_MAX:
            print(-1, end=" ")
        else:
            print(dist[i][j], end=" ")
    print()
