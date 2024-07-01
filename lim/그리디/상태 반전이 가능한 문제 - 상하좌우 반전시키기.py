import sys


def sol(n, grid):
    drs = [1, -1, 0, 0, 0]
    dcs = [0, 0, 1, -1, 0]

    def in_range(r, c):
        return r >= 0 and c >= 0 and r < n and c < n

    def flip(r, c):
        for dr, dc in zip(drs, dcs):
            nr, nc = r + dr, c + dc
            if in_range(nr, nc):
                grid[nr][nc] = (grid[nr][nc] + 1) % 2

    count = 0
    for i in range(1, n):
        for j in range(n):
            if grid[i-1][j] == 0:
                flip(i, j)
                count += 1

    for i in range(n):
        if grid[-1][i] == 0:
            print(-1)
            return
    print(count)


n = int(sys.stdin.readline())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
sol(n, grid)
