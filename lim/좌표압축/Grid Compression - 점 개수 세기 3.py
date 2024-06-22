import sys


def sol(n, arr, queries):
    idx_by_value = {num: i for i, num in enumerate(arr)}

    for s, e in queries:
        s_i, e_i = idx_by_value[s], idx_by_value[e]
        print(e_i - s_i + 1)


n, q = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(q)]

sol(n, arr, queries)
