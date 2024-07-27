def find_cookie_parts(N, grid):
    # 심장 위치 찾기
    heart_x = heart_y = -1
    for i in range(N):
        for j in range(N):
            if grid[i][j] == '*':
                if i + 1 < N and grid[i + 1][j] == '*':  # 아래에 '*'이 있는지 확인
                    heart_x = i + 1
                    heart_y = j
                    break
        if heart_x != -1:
            break
    
    # 왼쪽 팔 길이 계산
    left_arm = 0
    for j in range(heart_y - 1, -1, -1):
        if grid[heart_x][j] == '*':
            left_arm += 1
        else:
            break
    
    # 오른쪽 팔 길이 계산
    right_arm = 0
    for j in range(heart_y + 1, N):
        if grid[heart_x][j] == '*':
            right_arm += 1
        else:
            break
    
    # 허리 길이 계산
    waist = 0
    for i in range(heart_x + 1, N):
        if grid[i][heart_y] == '*':
            waist += 1
        else:
            break
    
    # 왼쪽 다리 길이 계산
    left_leg = 0
    leg_start_x = heart_x + waist + 1
    for i in range(leg_start_x, N):
        if grid[i][heart_y - 1] == '*':
            left_leg += 1
        else:
            break
    
    # 오른쪽 다리 길이 계산
    right_leg = 0
    for i in range(leg_start_x, N):
        if grid[i][heart_y + 1] == '*':
            right_leg += 1
        else:
            break
    
    return (heart_x + 1, heart_y + 1), (left_arm, right_arm, waist, left_leg, right_leg)

# 입력 처리
N = int(input())
grid = [input().strip() for _ in range(N)]

# 신체 부위 찾기
heart_pos, parts_lengths = find_cookie_parts(N, grid)

# 결과 출력
print(heart_pos[0], heart_pos[1])
print(" ".join(map(str, parts_lengths)))
