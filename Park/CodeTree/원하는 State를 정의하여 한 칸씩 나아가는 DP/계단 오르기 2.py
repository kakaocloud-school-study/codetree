# 계단의 층 수를 입력받습니다.
n = int(input())

# 각 층의 동전의 개수를 입력받습니다.
coin = [0] + list(map(int, input().split()))

# dp 배열 초기화
dp = [[0 for _ in range(5)] for _ in range(n + 1)]

# 기본 케이스 초기화
dp[1][1] = coin[1]
if n > 1:
    dp[2][0] = coin[2]
    dp[2][2] = coin[1] + coin[2]

# 동적 프로그래밍으로 최대 가치 계산
for i in range(3, n + 1):
    for j in range(4):
        if dp[i-2][j] != 0:
            dp[i][j] = max(dp[i][j], dp[i - 2][j] + coin[i])
        if j and dp[i - 1][j - 1] != 0:
            dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + coin[i])

# 최대 가치 출력
ans = max(dp[n])
print(ans)
