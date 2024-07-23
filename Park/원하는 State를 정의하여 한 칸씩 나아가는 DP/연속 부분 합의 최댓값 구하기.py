import sys

INT_MIN = -sys.maxsize

# 입력 받기
n = int(input())
a = [0] + list(map(int, input().split()))

# prefix_sum 배열 초기화 및 누적합 계산 함수
prefix_sum = [0] * (n + 1)

def preprocess():
    for i in range(1, n + 1):
        prefix_sum[i] = prefix_sum[i - 1] + a[i]

# 구간 합 계산 함수
def sum_in_range(i, j):
    return prefix_sum[j] - prefix_sum[i - 1]

preprocess()

ans = INT_MIN

# 모든 연속 부분수열의 합 중 최댓값 계산
for i in range(1, n + 1):
    for j in range(i, n + 1):
        ans = max(ans, sum_in_range(i, j))

print(ans)
