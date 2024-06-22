import sys
from bisect import bisect_left, bisect_right
from copy import deepcopy


def sol(n, points, queries):
    x_values = sorted(list(set(map(lambda p: p[0], points))))
    y_values = sorted(list(set(map(lambda p: p[1], points))))
    compressed_grid = [[0] * (len(y_values)+1) for _ in range(len(x_values)+1)]

    for x, y in points:
        i, j = bisect_left(x_values, x), bisect_left(y_values, y)
        compressed_grid[i][j] = 1
    prefix_sum_grid = deepcopy(compressed_grid)
    for i in range(len(x_values)):
        for j in range(1, len(y_values)):
            prefix_sum_grid[i][j] += prefix_sum_grid[i][j-1]
        if i == 0:
            continue
        for j in range(len(y_values)):
            prefix_sum_grid[i][j] += prefix_sum_grid[i-1][j]

    def get_count(i1, j1, i2, j2):
        upper_square = 0 if i1 < 1 else prefix_sum_grid[i1-1][j2]
        left_square = 0 if j1 < 1 else prefix_sum_grid[i2][j1-1]
        intersection_square = 0 if i1 < 1 or j1 < 1 else prefix_sum_grid[i1-1][j1-1]
        return prefix_sum_grid[i2][j2] - left_square - upper_square + intersection_square

    for x1, y1, x2, y2 in queries:
        i1, j1, i2, j2 = (
            bisect_left(x_values, x1),
            bisect_left(y_values, y1),
            bisect_right(x2)-1,
            bisect_right(y2)-1,
        )
        count = get_count(i1, j1, i2, j2)
        print(count)


n, q = map(int, sys.stdin.readline().split())
points = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(q)]

sol(n, points, queries)
