'''
부분수열 최대합 dp의 응용
col에 대해서 시작, 끝 값을 for문 2중으로 돌려 시도한다. 한 행의 부분수열합은 누적합으로 상수시간안에 구한다
col 시작끝 범위와 그 합이 각각 row마다 구해진상태에서 부분수열 최대합 dp를 적용한다
'''

import sys
from copy import deepcopy


def sol(n, grid):
    prefix_sums = deepcopy(grid)
    for i in range(1, n+1):
        for j in range(1, n+1):
            prefix_sums[i][j] += prefix_sums[i][j-1]

    max_sum = -sys.maxsize
    for s_j in range(1, n+1):
        for e_j in range(s_j, n+1):
            dp = [-sys.maxsize]*(n+1)
            for i in range(1, n+1):
                range_sum = prefix_sums[i][e_j] - prefix_sums[i][s_j-1]
                if dp[i-1] > 0:
                    dp[i] = dp[i-1] + range_sum
                else:
                    dp[i] = range_sum
            max_sum = max(max_sum, *dp)
    print(max_sum)


n = int(sys.stdin.readline())
grid = [[0] * (n+1)] + [[0] + list(map(int, sys.stdin.readline().split()))
                        for _ in range(n)]

sol(n, grid)
