from collections import deque

# 변수 선언 및 입력
n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

visited = [[False] * m for _ in range(n)]

# 주어진 위치가 격자를 벗어나는지 확인
def in_range(x, y):
    return 0 <= x < n and 0 <= y < m

# 주어진 위치로 이동 가능한지 확인
def can_go(x, y):
    return in_range(x, y) and a[x][y] and not visited[x][y]

# BFS 탐색
def bfs():
    q = deque([(0, 0)])  # 시작점 추가
    visited[0][0] = True
    dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]  # 방향 설정

    while q:
        x, y = q.popleft()
        for dx, dy in zip(dxs, dys):
            new_x, new_y = x + dx, y + dy
            if can_go(new_x, new_y):
                q.append((new_x, new_y))
                visited[new_x][new_y] = True

# BFS 수행
bfs()

# 우측 하단 방문 여부 확인
print(1 if visited[n - 1][m - 1] else 0)
