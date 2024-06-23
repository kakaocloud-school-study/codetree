import sys


def sol(n, points):
    x_diffs = []
    y_diffs = []
    for i in range(n-1):
        x1, y1 = points[i]
        x2, y2 = points[i+1]
        x_diffs.append(abs(x1-x2))
        y_diffs.append(abs(y1-y2))
    l_x_sum = list(x_diffs)
    r_x_sum = list(x_diffs)
    l_y_sum = list(y_diffs)
    r_y_sum = list(y_diffs)
    for i in range(1, n-1):
        l_x_sum[i] += l_x_sum[i-1]
        r_x_sum[n-2-i] += r_x_sum[n-1-i]
        l_y_sum[i] += l_y_sum[i-1]
        r_y_sum[n-2-i] += r_y_sum[n-1-i]

    min_dist = sys.maxsize
    for i in range(1, n-1):
        x1, y1 = points[i-1]
        x2, y2 = points[i+1]
        l_x = 0 if i < 2 else l_x_sum[i-2]
        r_x = 0 if i > n-3 else r_x_sum[i+1]
        l_y = 0 if i < 2 else l_y_sum[i-2]
        r_y = 0 if i > n-3 else r_y_sum[i+1]
        dist = l_x + r_x + abs(x1-x2) + l_y + r_y + abs(y1-y2)
        min_dist = min(min_dist, dist)
    print(min_dist)


n = int(sys.stdin.readline())
points = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(n, points)
