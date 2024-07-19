'''
3 3 4 4 4 5
-> 3:2, 4:3, 5:1 카운트
3, 4, 5를 순회하며 각 숫자 num과 k - num 의 카운트를 곱하고 누적해간다
"i위치 숫자 + j위치 숫자" 인 경우와 "j위치 숫자 + i위치 숫자" 인 경우는 하나의 경우이므로 전체 합을 2로 나눠 중복을 없앤다
'''
from collections import defaultdict
import sys


def sol(n, k, arr):
    count_by_num = defaultdict(int)
    for num in arr:
        count_by_num[num] += 1

    total = 0
    for num in list(count_by_num.keys()):
        if num == k // 2 and k % 2 == 0:
            total += count_by_num[k//2] * (count_by_num[k//2] - 1)
        else:
            total += count_by_num[num] * count_by_num[k-num]
    return total // 2


n, k = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
print(sol(n, k, arr))
