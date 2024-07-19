import sys


def sol(n, k, arr):
    prefix_sum = [0] + list(arr)
    for i in range(1, n+1):
        prefix_sum[i] += prefix_sum[i-1]
    count = 0
    for i in range(1, n+1):
        for j in range(0, i):
            range_sum = prefix_sum[i] - prefix_sum[j]
            if range_sum == k:
                count += 1
    print(count)


n, k = list(map(int, sys.stdin.readline().split()))
arr = list(map(int, sys.stdin.readline().split()))

sol(n, k, arr)
