import sys
from collections import deque

INT_MAX = sys.maxsize

# 변수 선언 및 입력
n = int(input())
r1, c1, r2, c2 = map(int, input().split())
r1, c1, r2, c2 = r1 - 1, c1 - 1, r2 - 1, c2 - 1

q = deque()
visited = [[False] * n for _ in range(n)]  # 방문 여부 체크
step = [[0] * n for _ in range(n)]  # 최단 거리 기록

ans = INT_MAX

# 좌표가 격자 내에 있는지 확인
def in_range(x, y):
    return 0 <= x < n and 0 <= y < n

# 이동 가능 여부 확인
def can_go(x, y):
    return in_range(x, y) and not visited[x][y]

# 큐에 새로운 위치를 추가하고 방문 및 최단 거리 갱신
def push(nx, ny, new_step):
    q.append((nx, ny))
    visited[nx][ny] = True
    step[nx][ny] = new_step

# 최소 이동 횟수를 찾는 함수
def find_min():
    global ans
    
    while q:
        x, y = q.popleft()

        dxs = [-2, -2, -1, -1, 1, 1, 2, 2]
        dys = [-1, 1, -2, 2, -2, 2, -1, 1]

        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy

            if can_go(nx, ny):
                push(nx, ny, step[x][y] + 1)
    
    if visited[r2][c2]:
        ans = step[r2][c2]

# 시작점을 큐에 넣고 BFS 시작
push(r1, c1, 0)
find_min()

# 출력: 불가능한 경우 -1 출력
if ans == INT_MAX:
    ans = -1

print(ans)
