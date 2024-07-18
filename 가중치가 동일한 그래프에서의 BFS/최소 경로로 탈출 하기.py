import sys
sys.setrecursionlimit(10000)  # 재귀 한도 설정

INT_MAX = sys.maxsize

# 변수 선언 및 입력
n, m = map(int, input().split())

a = [list(map(int, input().split())) for _ in range(n)]

visited = [[False] * m for _ in range(n)]  # 방문 여부 체크

ans = INT_MAX  # 최소 이동 횟수 저장

# 좌표가 격자 내에 있는지 확인
def in_range(x, y):
    return 0 <= x < n and 0 <= y < m

# 이동 가능 여부 확인
def can_go(x, y):
    return in_range(x, y) and a[x][y] and not visited[x][y]

# 최소 이동 횟수를 찾는 함수
def find_min(x, y, cnt):
    global ans
    
    if x == n - 1 and y == m - 1:  # 도착점에 도달한 경우
        ans = min(ans, cnt)
        return
    
    # 4방향 이동 (우, 하, 좌, 상)
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    
    for dx, dy in directions:
        new_x, new_y = x + dx, y + dy
        
        if can_go(new_x, new_y):
            visited[new_x][new_y] = True
            find_min(new_x, new_y, cnt + 1)
            visited[new_x][new_y] = False  # 백트래킹

# 초기 위치에서 시작
visited[0][0] = True
find_min(0, 0, 0)

# 불가능한 경우 -1 출력
if ans == INT_MAX:
    ans = -1

print(ans)
