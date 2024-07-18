# 변수 선언 및 입력
n, m = tuple(map(int, input().split()))
grid = [list(map(int, input().split())) for _ in range(n)]

# 행복한 수열인지 판별하는 함수
def is_happy_sequence(sequence):
    max_length = 1  # 최대 연속 길이를 기록하는 변수, 초기값은 1로 설정
    current_length = 1  # 현재 연속 길이를 기록하는 변수, 초기값은 1로 설정
    
    # 시퀀스의 두 번째 요소부터 시작해서 순회
    for i in range(1, len(sequence)):
        if sequence[i] == sequence[i - 1]:  # 현재 요소가 이전 요소와 같다면
            current_length += 1  # 현재 연속 길이를 증가시킴
        else:
            current_length = 1  # 현재 요소가 이전 요소와 다르면 연속 길이를 1로 초기화
        
        if current_length > max_length:  # 현재 연속 길이가 최대 연속 길이보다 크다면
            max_length = current_length  # 최대 연속 길이를 현재 연속 길이로 업데이트
    
    return max_length >= m  # 최대 연속 길이가 m 이상이면 True를 반환

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
