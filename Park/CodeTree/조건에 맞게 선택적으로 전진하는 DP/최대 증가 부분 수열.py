n = int(input())

# 0번 인덱스에 0을 추가
a = [0] + list(map(int, input().split()))

# dp 배열 초기화
dp = [0 for _ in range(n + 1)]

for i in range(1, n + 1):
    # a[i]보다 작은 원소 중 최장 부분 수열 길이 계산
    for j in range(i):
        if a[j] < a[i]:
            dp[i] = max(dp[i], dp[j] + 1)

# 최장 부분 수열의 길이 출력
print(max(dp))
