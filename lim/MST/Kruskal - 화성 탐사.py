import sys
from collections import deque


class UnionFind:
    def __init__(self, size):
        self.root_of = [num for num in range(size + 1)]

    def find(self, num):
        parent = self.root_of[num]
        if num == parent:
            return num
        root = self.find(parent)
        self.root_of[num] = root
        return root

    def union(self, num1, num2):
        root1 = self.find(num1)
        root2 = self.find(num2)
        if root1 == root2:
            return
        self.root_of[root1] = root2

    def is_union(self, num1, num2):
        root1 = self.find(num1)
        root2 = self.find(num2)
        return root1 == root2


def kruskal(n, edges):
    uf = UnionFind(n)
    edges.sort(key=lambda x: x[2])

    total_cost = 0
    edge_count = 0
    for s, e, cost in edges:
        if edge_count >= n-1:
            break
        if uf.is_union(s, e):
            continue
        uf.union(s, e)
        total_cost += cost
        edge_count += 1
    if edge_count != n-1:
        print(-1)
        return
    print(total_cost)


def sol(n, grid):
    edges = []
    id_grid = [[0]*n for _ in range(n)]
    next_id = 1
    for i in range(n):
        for j in range(n):
            if grid[i][j] > 0:
                id_grid[i][j] = next_id
                next_id += 1

    def in_range(r, c):
        return r >= 0 and c >= 0 and r < n and c < n and grid[r][c] != -1

    def bfs(r, c):
        drs = [1, -1, 0, 0]
        dcs = [0, 0, 1, -1]
        dq = deque([(r, c, 0)])
        visited = set([(r, c)])
        origin_id = id_grid[r][c]
        while len(dq):
            r, c, depth = dq.popleft()
            if grid[r][c] > 0:
                edges.append((origin_id, id_grid[r][c], depth))
            for dr, dc in zip(drs, dcs):
                nr, nc = r + dr, c + dc
                if not in_range(nr, nc) or (nr, nc) in visited:
                    continue
                visited.add((nr, nc))
                dq.append((nr, nc, depth + 1))

    for i in range(n):
        for j in range(n):
            if grid[i][j] > 0:
                bfs(i, j)
    edges.sort(key=lambda x: x[2])
    kruskal(next_id - 1, edges)


n = int(sys.stdin.readline())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(n, grid)
