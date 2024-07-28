n = int(input())

# 그리드 입력 받기
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

# 최대 합 초기화
max_sum = 0

# 범위 내에 있는지 확인하는 함수
def in_range(x, y):
    return 0 <= x < n and 0 <= y < n

# 최대 합을 찾는 함수
def find_max_sum(x, y, sum):
    global max_sum
    
    # 도착 지점에 도달하면 최대 합 갱신
    if x == n - 1 and y == n - 1:
        max_sum = max(max_sum, sum)
        return
    
    # 이동할 수 있는 방향 (오른쪽, 아래쪽)
    dxs, dys = [1, 0], [0, 1]
    
    # 모든 방향 탐색
    for dx, dy in zip(dxs, dys):
        new_x, new_y = x + dx, y + dy
        
        if in_range(new_x, new_y):
            find_max_sum(new_x, new_y, sum + grid[new_x][new_y])

# 탐색 시작
find_max_sum(0, 0, grid[0][0])

# 결과 출력
print(max_sum)
