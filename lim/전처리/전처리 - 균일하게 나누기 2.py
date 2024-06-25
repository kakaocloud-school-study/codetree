'''
행렬 누적합으로 풀이함
'''
import sys


def sol(n, grid):
    MAX_POS = 1000
    for i in range(1, MAX_POS + 1):
        for j in range(1, MAX_POS + 1):
            grid[i][j] += grid[i][j-1]
        for j in range(1, MAX_POS + 1):
            grid[i][j] += grid[i-1][j]

    def get_max_m(a, b):
        quarters = [0] * 4
        quarters[0] = grid[a][MAX_POS] - grid[a][b]
        quarters[1] = grid[a][b]
        quarters[2] = grid[MAX_POS][b] - grid[a][b]
        quarters[3] = (
            grid[MAX_POS][MAX_POS]
            - grid[a][MAX_POS]
            - grid[MAX_POS][b]
            + grid[a][b]
        )
        return max(quarters)

    min_max_m = sys.maxsize
    for i in range(2, MAX_POS + 1, 2):
        for j in range(2, MAX_POS + 1, 2):
            min_max_m = min(min_max_m, get_max_m(i, j))
    print(min_max_m)


n = int(sys.stdin.readline())
grid = [[0] * 1_001 for _ in range(1_001)]
points = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
for x, y in points:
    grid[x][y] = 1

sol(n, grid)
