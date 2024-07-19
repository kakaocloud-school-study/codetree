'''
arr: 빈칸은 1 그 외는 0으로 표시. 누적합으로 범위합을 구하면 범위합은 범위내 빈칸의 개수를 나타냄
'''

import sys


def sol(n, k, arr):
    prefix_sum = [0] + list(arr)
    for i in range(1, n+1):
        prefix_sum[i] += prefix_sum[i-1]
    min_count = sys.maxsize
    for i in range(k, n+1):
        blank_count = prefix_sum[i] - prefix_sum[i-k]
        min_count = min(min_count, blank_count)
    print(min_count)


n, k, b = list(map(int, sys.stdin.readline().split()))
blanks = set([int(sys.stdin.readline()) for _ in range(b)])
arr = [1 if num in blanks else 0 for num in range(1, n+1)]

sol(n, k, arr)
