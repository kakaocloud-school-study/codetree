import sys


def sol(n, k, bombs):
    prev_pos_by_num = dict()

    max_bang = -1
    for i, num in enumerate(bombs):
        if prev_pos_by_num.get(num) != None and prev_pos_by_num[num] + k >= i:
            max_bang = max(max_bang, num)
        prev_pos_by_num[num] = i
    print(max_bang)


n, k = map(int, sys.stdin.readline().split())
bombs = [int(sys.stdin.readline()) for _ in range(n)]

sol(n, k, bombs)
