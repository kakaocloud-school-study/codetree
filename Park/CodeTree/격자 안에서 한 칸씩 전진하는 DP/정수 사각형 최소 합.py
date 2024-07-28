# 변수 선언 및 입력:
n = int(input())
num = [
    list(map(int, input().split()))
    for _ in range(n)
] 
dp = [
    [0] * n
    for _ in range(n)
]

def initialize():
    # 시작점의 경우 dp[0][0] = num[0][0]으로 초기값을 설정해줍니다
    dp[0][0] = num[0][0]

    # 최좌측 열의 초기값을 설정해줍니다.
    for i in range(1, n):
        dp[i][0] = dp[i - 1][0] + num[i][0]

    # 최상단 행의 초기값을 설정해줍니다.
    for j in range(1, n):
        dp[0][j] = dp[0][j - 1] + num[0][j]

# 초기값 설정
initialize()

# 탐색하는 위치의 위에 값과 왼쪽 값 중에 큰 값에
# 해당 위치의 숫자를 더해줍니다.
for i in range(1, n):
    for j in range(1, n): 
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + num[i][j]

# 최종 결과 출력
print(dp[n - 1][n - 1])
