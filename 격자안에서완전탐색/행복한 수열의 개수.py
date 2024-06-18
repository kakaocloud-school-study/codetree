# 변수 선언 및 입력
n, m = tuple(map(int, input().split()))
grid = [list(map(int, input().split())) for _ in range(n)]

# 행복한 수열인지 판별하는 함수
def is_happy_sequence(sequence):
    max_length = 1
    current_length = 1
    
    for i in range(1, len(sequence)):
        if sequence[i] == sequence[i - 1]:
            current_length += 1
        else:
            current_length = 1
        
        if current_length > max_length:
            max_length = current_length
    
    return max_length >= m

num_happy = 0

# 가로로 행복한 수열의 수를 셈
for row in grid:
    if is_happy_sequence(row):
        num_happy += 1

# 세로로 행복한 수열의 수를 셈
for j in range(n):
    column = [grid[i][j] for i in range(n)]
    if is_happy_sequence(column):
        num_happy += 1

print(num_happy)
