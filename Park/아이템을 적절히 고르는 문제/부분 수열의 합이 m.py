MAX_ANS = 101

# 입력 받기
n, m = map(int, input().split())
arr = list(map(int, input().split()))

# dp[i]: 합이 i일 때, 가능한 최소 수열의 길이
dp = [0] * (m + 1)

def initialize():
    for i in range(m + 1):
        dp[i] = MAX_ANS  # 초기값 설정
    dp[0] = 0  # 초기 조건 설정

initialize()

# 각 수들을 선택해봅니다.
for i in range(n):
    for j in range(m, -1, -1):
        if j >= arr[i]:
            dp[j] = min(dp[j], dp[j - arr[i]] + 1)

# 결과 구하기
min_len = dp[m]
if min_len == MAX_ANS:
    min_len = -1

print(min_len)
