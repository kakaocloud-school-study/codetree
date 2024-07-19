import sys


def sol(n, s, arr):
    s_i, e_i = 0, 0
    curr_sum = arr[0]
    min_range = sys.maxsize
    while s_i <= e_i:
        while curr_sum < s and e_i < n-1:
            e_i += 1
            curr_sum += arr[e_i]
        if curr_sum >= s:
            min_range = min(min_range, e_i - s_i + 1)
        if s_i < n-1:
            curr_sum -= arr[s_i]
        s_i += 1

    print(min_range if min_range != sys.maxsize else -1)


n, s = list(map(int, sys.stdin.readline().split()))
arr = list(map(int, sys.stdin.readline().split()))

sol(n, s, arr)
