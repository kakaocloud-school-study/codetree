import sys


def sol(n, k, arr):
    prefix_sum = [0] + list(arr)
    for i in range(1, n+1):
        prefix_sum[i] += prefix_sum[i-1]
    max_range_sum = -sys.maxsize
    for i in range(k, n+1):
        range_sum = prefix_sum[i] - prefix_sum[i-k]
        max_range_sum = max(max_range_sum, range_sum)
    print(max_range_sum)


n, k = list(map(int, sys.stdin.readline().split()))
arr = list(map(int, sys.stdin.readline().split()))

sol(n, k, arr)
