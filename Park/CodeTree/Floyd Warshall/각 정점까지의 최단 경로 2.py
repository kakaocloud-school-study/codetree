import sys

# 상수값으로 최대값 설정
INT_MAX = sys.maxsize

# 변수 선언 및 입력 받기
n, m = map(int, input().split())

# 초기 거리 배열을 큰 값으로 설정
dist = [[INT_MAX] * (n + 1) for _ in range(n + 1)]

# 자기 자신으로 가는 거리는 0으로 설정
for i in range(1, n + 1):
    dist[i][i] = 0

# 그래프를 인접 행렬로 표현
for _ in range(m):
    x, y, z = map(int, input().split())
    dist[x][y] = min(dist[x][y], z)  # 최솟값 갱신

# 플로이드-워셜 알고리즘 수행
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if dist[i][k] != INT_MAX and dist[k][j] != INT_MAX:  # 필요없는 계산 방지
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

# 최단 거리 결과 출력
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if dist[i][j] == INT_MAX:
            print(-1, end=" ")
        else:
            print(dist[i][j], end=" ")
    print()
