# 변수 선언 및 입력
n, m, t = map(int, input().split())
a = [[0] * (n + 1)]
for _ in range(n):
    a.append([0] + list(map(int, input().split())))

count = [[0] * (n + 1) for _ in range(n + 1)]
next_count = [[0] * (n + 1) for _ in range(n + 1)]

# 범위가 격자 안에 들어가는지 확인
def in_range(x, y):
    return 1 <= x <= n and 1 <= y <= n

# 인접한 곳들 중 가장 값이 큰 위치 반환
def get_max_neighbor_pos(x, y):
    dxs, dys = [-1, 1, 0, 0], [0, 0, -1, 1]
    max_val, max_pos = 0, (0, 0)
    
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if in_range(nx, ny) and a[nx][ny] > max_val:
            max_val, max_pos = a[nx][ny], (nx, ny)
    
    return max_pos

# (x, y) 위치의 구슬을 이동
def move(x, y):
    nx, ny = get_max_neighbor_pos(x, y)
    next_count[nx][ny] += 1

# 모든 구슬을 이동
def move_all():
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            next_count[i][j] = 0
    
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if count[i][j] == 1:
                move(i, j)
    
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            count[i][j] = next_count[i][j]

# 중복된 구슬 제거
def remove_duplicates():
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if count[i][j] >= 2:
                count[i][j] = 0

# 시뮬레이션 실행
def simulate():
    move_all()
    remove_duplicates()

# 초기 구슬 위치 설정
for _ in range(m):
    x, y = map(int, input().split())
    count[x][y] = 1

# t초 동안 시뮬레이션 진행
for _ in range(t):
    simulate()

# 결과 출력
print(sum(sum(row) for row in count))
