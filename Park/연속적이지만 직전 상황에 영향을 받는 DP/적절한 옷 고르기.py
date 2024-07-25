import sys

INT_MIN = -sys.maxsize

# 변수 선언 및 입력
n, m = map(int, input().split())
s, e, v = [0] * (n + 1), [0] * (n + 1), [0] * (n + 1)

for i in range(1, n + 1):
    s[i], e[i], v[i] = map(int, input().split())

# dp[i][j] : i번째 날까지 입을 옷을 전부 결정했고
# 마지막 날에 입은 옷이 j번 옷이라 했을 때, 얻을 수 있는 최대 만족도
dp = [[INT_MIN] * (n + 1) for _ in range(m + 1)]

# 첫 날의 초기 조건 설정
for j in range(1, n + 1):
    if s[j] <= 1 <= e[j]:
        dp[1][j] = 0

# DP 배열 채우기
for i in range(2, m + 1):
    for j in range(1, n + 1):
        if s[j] <= i <= e[j]:
            for k in range(1, n + 1):
                if s[k] <= i - 1 <= e[k]:
                    dp[i][j] = max(dp[i][j], dp[i - 1][k] + abs(v[j] - v[k]))

# 결과 계산
ans = max(dp[m][1:n + 1])
print(ans)
