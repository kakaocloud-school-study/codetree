import sys

INT_MIN = -sys.maxsize

# 변수 선언 및 입력
n = int(input())
arr = list(map(int, input().split()))

# dp[i] : 위치 i에 도착할 때 가능한 최대 점프 횟수
dp = [0] * n

def initialize():
    # 초기값을 INT_MIN으로 설정
    for i in range(n):
        dp[i] = INT_MIN
    
    # 시작 위치의 초기조건 설정
    dp[0] = 0

# 초기조건 설정
initialize()

# 점화식을 통해 dp 값 채우기
for i in range(1, n):
    for j in range(i):
        if dp[j] == INT_MIN:
            continue
        if j + arr[j] >= i:
            dp[i] = max(dp[i], dp[j] + 1)

# 최댓값 계산
ans = max(dp)
print(ans)
