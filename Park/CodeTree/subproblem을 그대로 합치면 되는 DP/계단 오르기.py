MAX_N = 1000
MOD = 10007

# 입력 받기
n = int(input("숫자를 입력하세요: "))
dp = [0] * (MAX_N + 1)

# 초기값 설정
dp[0] = 1
dp[2] = 1
dp[3] = 1

# 점화식 계산
for i in range(4, n + 1):
    dp[i] = (dp[i - 2] + dp[i - 3]) % MOD

print(dp[n])  # 결과 출력
