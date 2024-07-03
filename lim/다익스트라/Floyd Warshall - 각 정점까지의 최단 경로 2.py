import sys


def sol(n, m, grid):
    for k in range(n):
        for i in range(n):
            for j in range(n):
                grid[i][j] = min(grid[i][j], grid[i][k] + grid[k][j])
    for i in range(n):
        for j in range(n):
            if grid[i][j] == sys.maxsize:
                print(-1, end=' ')
                continue
            print(grid[i][j], end=' ')
        print()


n, m = map(int, sys.stdin.readline().split())
grid = [[sys.maxsize] * n for _ in range(n)]
for i in range(n):
    grid[i][i] = 0
for _ in range(m):
    s, e, c = map(int, sys.stdin.readline().split())
    grid[s-1][e-1] = min(grid[s-1][e-1], c)

sol(n, m, grid)
