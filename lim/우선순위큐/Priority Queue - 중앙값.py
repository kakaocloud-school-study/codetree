'''
upper_min_hq: 중앙값을 포함한 오름차순 상위 원소들을 보관하는 최소힙
lower_max_hq: 중앙값을 제외한 오름차순 하위 원소들을 보관하는 최대힙
'''

import heapq
import sys


def sol(n, arr):
    lower_max_hq = []
    upper_min_hq = []

    def get_median():
        while len(lower_max_hq) < len(upper_min_hq) - 1:
            item = heapq.heappop(upper_min_hq)
            heapq.heappush(lower_max_hq, -item)
        while len(lower_max_hq) and len(upper_min_hq) and (-lower_max_hq[0]) > upper_min_hq[0]:
            upper_min = heapq.heappop(upper_min_hq)
            lower_max = -heapq.heappop(lower_max_hq)
            heapq.heappush(lower_max_hq, -upper_min)
            heapq.heappush(upper_min_hq, lower_max)
        return upper_min_hq[0]

    for i, num in enumerate(arr):
        order = i + 1
        heapq.heappush(upper_min_hq, num)
        if order % 2 == 1:
            print(get_median(), end=' ')

    print()


t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))

    sol(n, arr)
