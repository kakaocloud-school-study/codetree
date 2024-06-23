import sys
from copy import deepcopy


def sol(n, rounds):
    results = [
        [1 if r == 'H' else 0 for r in rounds],
        [1 if r == 'S' else 0 for r in rounds],
        [1 if r == 'P' else 0 for r in rounds]
    ]

    l_sums = deepcopy(results)
    r_sums = deepcopy(results)

    for i in range(1, n):
        l_sums[0][i] += l_sums[0][i-1]
        l_sums[1][i] += l_sums[1][i-1]
        l_sums[2][i] += l_sums[2][i-1]
        r_sums[0][n-i-1] += r_sums[0][n-i]
        r_sums[1][n-i-1] += r_sums[1][n-i]
        r_sums[2][n-i-1] += r_sums[2][n-i]

    max_wins = -sys.maxsize
    for i in range(n):
        for l_idx in range(3):
            for r_idx in range(3):
                l_sum_value = 0 if i < 1 else l_sums[l_idx][i-1]
                r_sum_value = 0 if i >= n else r_sums[r_idx][i]
                max_wins = max(max_wins, l_sum_value + r_sum_value)
    print(max_wins)


n = int(sys.stdin.readline())
rounds = [sys.stdin.readline().strip() for _ in range(n)]

sol(n, rounds)
