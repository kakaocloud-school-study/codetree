import sys


def sol(n, s, arr):
    curr_sum = arr[0]
    count = 0
    e_i = 0
    for s_i in range(n):
        while curr_sum < s and e_i < n-1:
            e_i += 1
            curr_sum += arr[e_i]
        if curr_sum == s:
            count += 1

        curr_sum -= arr[s_i]

    print(count)


n, s = list(map(int, sys.stdin.readline().split()))
arr = list(map(int, sys.stdin.readline().split()))

sol(n, s, arr)
