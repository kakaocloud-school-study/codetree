def max_exploration_value(N, M, grid):
    # DP 배열 초기화
    dp = [[0] * M for _ in range(N)]
    
    # 첫 번째 칸은 무조건 탐사한다
    dp[0][0] = grid[0][0]
    
    # 첫 번째 행을 먼저 계산 (오른쪽 방향으로만 이동 가능)
    for j in range(1, M):
        dp[0][j] = dp[0][j - 1] + grid[0][j]
    
    # 각 행에 대해 최대 가치 계산
    for i in range(1, N):
        # 왼쪽에서 오른쪽으로 진행하며 dp 값을 갱신
        left_to_right = dp[i][:]  # i번째 행의 값 복사
        
        for j in range(M):
            if j == 0:
                left_to_right[j] = dp[i-1][j] + grid[i][j]
            else:
                left_to_right[j] = max(dp[i-1][j], left_to_right[j-1]) + grid[i][j]
        
        # 오른쪽에서 왼쪽으로 진행하며 dp 값을 갱신
        right_to_left = dp[i][:]  # i번째 행의 값 복사
        
        for j in range(M-1, -1, -1):
            if j == M-1:
                right_to_left[j] = dp[i-1][j] + grid[i][j]
            else:
                right_to_left[j] = max(dp[i-1][j], right_to_left[j+1]) + grid[i][j]
        
        # 두 경로의 최대 값을 dp에 저장
        for j in range(M):
            dp[i][j] = max(left_to_right[j], right_to_left[j])
    
    # 오른쪽 아래 값이 최대 가치
    return dp[N-1][M-1]

# 입력 받기
N, M = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]

# 결과 출력
print(max_exploration_value(N, M, grid))
