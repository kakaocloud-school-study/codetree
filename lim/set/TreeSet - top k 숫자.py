import sys

from sortedcontainers import SortedSet


def sol(n, k, arr):
    my_set = SortedSet(arr)

    for num in reversed(my_set[-k:]):
        print(num, end=' ')


n, k = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

sol(n, k, arr)
