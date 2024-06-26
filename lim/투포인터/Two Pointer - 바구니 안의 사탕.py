import sys


def sol(n, k, candy_at):
    MAX_POSTION = 1_000_000
    window_size = 2*k + 1
    max_count = 0
    e_i = 0
    count = candy_at[0]
    for s_i in range(MAX_POSTION + 1):
        while e_i < MAX_POSTION and e_i < s_i + window_size - 1:
            e_i += 1
            count += candy_at[e_i]
        max_count = max(max_count, count)

        count -= candy_at[s_i]
    print(max_count)


n, k = list(map(int, sys.stdin.readline().split()))
candy_at = [0] * (1_000_001)
candies = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
for count, pos in candies:
    candy_at[pos] += count
sol(n, k, candy_at)
