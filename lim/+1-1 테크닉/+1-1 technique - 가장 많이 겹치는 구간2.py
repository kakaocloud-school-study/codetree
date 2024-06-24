'''
x 좌표 한도가 10**9 이므로 좌표축소를 사용
'''

import sys


def sol(n, sticks):
    counts = [0] * 200_002
    x_values = []
    for x1, x2 in sticks:
        x_values.append(x1)
        x_values.append(x2)
    x_values.sort()
    idx_by_value = {value: i for i, value in enumerate(x_values)}

    for x1, x2 in sticks:
        counts[idx_by_value[x1]] += 1
        counts[idx_by_value[x2]+1] -= 1

    for i in range(1, len(counts)):
        counts[i] += counts[i-1]

    print(max(counts))


n = int(sys.stdin.readline())
sticks = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(n, sticks)
