# 변수 선언 및 입력
n, curr_x, curr_y = map(int, input().split())
a = [[0] * (n + 1)] + [[0] + list(map(int, input().split())) for _ in range(n)]

# 방문한 숫자를 담을 리스트
visited_nums = []

# 범위 확인 함수
def in_range(x, y):
    return 1 <= x <= n and 1 <= y <= n

# 이동 가능 여부 확인 함수
def can_go(x, y, curr_num):
    return in_range(x, y) and a[x][y] > curr_num

# 시뮬레이션 함수
def simulate():
    global curr_x, curr_y
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    for dx, dy in directions:
        next_x, next_y = curr_x + dx, curr_y + dy
        if can_go(next_x, next_y, a[curr_x][curr_y]):
            curr_x, curr_y = next_x, next_y
            return True
    return False

# 초기 위치 값 추가
visited_nums.append(a[curr_x][curr_y])

# 시뮬레이션 실행
while simulate():
    visited_nums.append(a[curr_x][curr_y])

# 결과 출력
print(' '.join(map(str, visited_nums)))
