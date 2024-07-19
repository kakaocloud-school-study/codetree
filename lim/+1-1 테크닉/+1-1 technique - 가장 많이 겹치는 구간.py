import sys


def sol(n, sticks):
    counts = [0] * 200_002

    for x1, x2 in sticks:
        counts[x1] += 1
        counts[x2+1] -= 1

    for i in range(1, len(counts)):
        counts[i] += counts[i-1]

    print(max(counts))


n = int(sys.stdin.readline())
sticks = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(n, sticks)
