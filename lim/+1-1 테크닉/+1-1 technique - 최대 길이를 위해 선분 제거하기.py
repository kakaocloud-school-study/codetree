'''
전체 덮이는 범위 길이합 - i번 선분이 한장만 덮이는 범위
"i번 선분이 한장만 덮이는 범위" 가 최소가되는 값을 찾아야 한다
'''
import sys


def sol(n, sticks):
    points = []
    for i, stick in enumerate(sticks):
        x1, x2 = stick
        points.append((x1, True, i))
        points.append((x2, False, i))
    points.sort()

    blanks = [0] * n
    prev_x = -1
    total_ranges = 0
    curr_stack_idxs = set()
    for x, start, idx in points:
        if len(curr_stack_idxs):
            total_ranges += (x - prev_x)
        if len(curr_stack_idxs) == 1:
            curr_stack_idx = list(curr_stack_idxs)[0]
            blanks[curr_stack_idx] += (x - prev_x)

        if start:
            curr_stack_idxs.add(idx)
        else:
            curr_stack_idxs.remove(idx)
        prev_x = x
    min_blank = min(blanks)
    print(total_ranges - min_blank)


n = int(sys.stdin.readline())
sticks = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(n, sticks)
