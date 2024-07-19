'''
뒤에서부터 시작하여 부분 수열 길이를 늘여가면 더 쉽게 구할 수 있다.(시간은 같음)
해당 풀이는 앞에서부터 n-1 길이인 부분 순열에서 이미 힙이 다 차있는 상태에서 빼가면서 구하였다.
그렇기 때문에 앞에서부터 뺀 원소를 set에 기록하여 각 순간 최소힙 top을 구하기 전에 힙을 싱크하였다. (이중 반복문이지만 결과적으로 nlogn임에 유의)
'''

import heapq
import sys


def sol(n, arr):
    hq = [(num, i) for i, num in enumerate(arr)]
    heapq.heapify(hq)
    popped_set = set()
    arr_sum = sum(arr)
    arr_len = len(arr)
    max_avg = 0

    for i in range(n-2):
        arr_sum -= arr[i]
        arr_len -= 1
        popped_set.add((arr[i], i))
        while hq[0] in popped_set:
            heapq.heappop(hq)
        min_elem, _ = hq[0]
        avg = (arr_sum - min_elem) / (arr_len - 1)
        max_avg = max(max_avg, avg)
    print('{:.2f}'.format(round(max_avg, 2)))


n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

sol(n, arr)
