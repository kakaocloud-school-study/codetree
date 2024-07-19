import heapq
import sys


def sol(n, arr):
    hq = []

    for num in arr:
        if num > 0:
            heapq.heappush(hq, -num)
            continue
        if len(hq) == 0:
            print(0)
            continue
        item = -heapq.heappop(hq)
        print(item)


n = int(sys.stdin.readline())
arr = [int(sys.stdin.readline()) for _ in range(n)]

sol(n, arr)
