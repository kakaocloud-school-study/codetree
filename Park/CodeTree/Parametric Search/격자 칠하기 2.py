import sys

# 재귀 함수의 깊이 제한을 늘려줍니다.
sys.setrecursionlimit(10000)

# 변수 선언 및 입력
n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

# 이동 방향을 정의합니다. (상, 하, 좌, 우)
directions = [(1, 0), (-1, 0), (0, -1), (0, 1)]

# 방문 여부를 저장하는 배열
visited = [[False] * n for _ in range(n)]

# dfs를 이용해 영역을 탐색하고 색칠된 칸의 개수를 반환.
def dfs(x, y, d):
    if visited[x][y]:
        return 0

    # 현재 칸 방문 처리
    visited[x][y] = True
    count = 1

    # 4방향으로 탐색합니다.
    for dx, dy in directions:
        nx, ny = x + dx, y + dy
        if 0 <= nx < n and 0 <= ny < n:  # 경계 체크
            # 인접한 칸의 높이 차이가 d 이하인 경우에만 탐색
            if abs(board[nx][ny] - board[x][y]) <= d:
                count += dfs(nx, ny, d)

    return count

# 주어진 d로 전체 영역의 절반 이상을 칠할 수 있는지 확인합니다.
def is_possible(d):
    # 방문 배열 초기화
    for i in range(n):
        for j in range(n):
            visited[i][j] = False

    # 모든 칸을 순회하며 절반 이상을 칠할 수 있는 영역이 있는지 확인
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                if dfs(i, j, d) * 2 >= n * n:
                    return True

    return False

# 이분 탐색을 통해 최소의 d 값을 찾습니다.
def find_minimum_d():
    lo, hi = 0, 1000000  # 초기 범위 설정
    ans = 0  # 답을 저장할 변수

    while lo <= hi:
        mid = (lo + hi) // 2  # 중간 값 계산
        if is_possible(mid):  # 해당 d로 조건을 만족하는지 확인
            ans = mid  # 현재 mid가 가능한 최소값이므로 갱신
            hi = mid - 1  # 더 작은 범위에서 탐색
        else:
            lo = mid + 1  # 더 큰 범위에서 탐색

    return ans

# 정답 출력
print(find_minimum_d())
