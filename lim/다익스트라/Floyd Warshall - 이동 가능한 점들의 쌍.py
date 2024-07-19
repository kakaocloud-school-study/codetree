import sys


def sol(n, m, grid, queries):
    global p
    for k in range(n):
        for i in range(n):
            for j in range(n):
                grid[i][j] = min(
                    grid[i][j], grid[i][k] + grid[k][j])
    count = 0
    total_cost = 0
    for s, e in queries:
        min_cost = sys.maxsize
        for red_node in range(p):
            if grid[s-1][red_node] != sys.maxsize and grid[red_node][e-1] != sys.maxsize:
                min_cost = min(min_cost, grid[s-1]
                               [red_node] + grid[red_node][e-1])
        if min_cost != sys.maxsize:
            count += 1
            total_cost += min_cost
    print(count)
    print(total_cost)


n, m, p, q = map(int, sys.stdin.readline().split())
grid = [[sys.maxsize] * n for _ in range(n)]
for i in range(n):
    grid[i][i] = 0
for _ in range(m):
    s, e, c = map(int, sys.stdin.readline().split())
    grid[s-1][e-1] = min(grid[s-1][e-1], c)
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(q)]

sol(n, m, grid, queries)
