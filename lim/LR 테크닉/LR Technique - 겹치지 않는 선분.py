'''
시작좌표에 대해 정렬한다.
특정 지점 i에 대해 "~i-1의 x2 좌표 최대값" < "i의 x2" < "i+1~의 x2 좌표 최소값" 을 만족하면 겹치지 않는다 
'''

import sys


def sol(n, sticks):
    sticks.sort(key=lambda x: x[0])
    lefts = [-sys.maxsize] * n
    rights = [sys.maxsize] * n
    left_max = -sys.maxsize
    right_min = sys.maxsize
    for i in range(n):
        x1, x2 = sticks[i]
        lefts[i] = left_max
        left_max = max(left_max, x2)
    for i in range(n-1, -1, -1):
        x1, x2 = sticks[i]
        rights[i] = right_min
        right_min = min(right_min, x2)
    count = 0
    for i in range(n):
        x1, x2 = sticks[i]
        if lefts[i] < x2 and x2 < rights[i]:
            count += 1
    print(count)


n = int(sys.stdin.readline())
sticks = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(n, sticks)
