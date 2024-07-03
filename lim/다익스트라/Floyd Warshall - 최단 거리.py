import sys


def sol(n, m, grid, queries):
    for k in range(n):
        for i in range(n):
            for j in range(n):
                grid[i][j] = min(grid[i][j], grid[i][k] + grid[k][j])
    for s, e in queries:
        print(grid[s-1][e-1])


n, m = map(int, sys.stdin.readline().split())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

sol(n, m, grid, queries)
