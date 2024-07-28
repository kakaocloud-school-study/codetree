from collections import deque

# 변수 선언 및 입력
n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# BFS에 필요한 변수들
bfs_q = deque()
visited = [[False] * n for _ in range(n)]

# 주어진 위치가 격자를 벗어나는지 확인
def in_range(x, y):
    return 0 <= x < n and 0 <= y < n

# 주어진 위치로 이동 가능한지 확인
def can_go(x, y):
    return in_range(x, y) and not grid[x][y] and not visited[x][y]

# BFS 탐색
def bfs():
    dxs, dys = [1, -1, 0, 0], [0, 0, 1, -1]  # 방향 설정

    while bfs_q:
        x, y = bfs_q.popleft()
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                bfs_q.append((nx, ny))
                visited[nx][ny] = True

# 시작점들을 큐에 추가
for _ in range(k):
    x, y = map(int, input().split())
    bfs_q.append((x - 1, y - 1))
    visited[x - 1][y - 1] = True

# BFS 수행
bfs()

# 방문한 칸의 수 계산
ans = sum(1 for i in range(n) for j in range(n) if visited[i][j])

print(ans)
