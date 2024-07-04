import sys


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


def sol(n, m, node_types, edges):
    uf = UnionFind(n)
    edges.sort(key=lambda x: x[2])

    total_cost = 0
    edge_count = 0
    for s, e, cost in edges:
        if edge_count >= n-1:
            break
        if node_types[s] == node_types[e]:
            continue
        if uf.is_union(s, e):
            continue
        uf.union(s, e)
        total_cost += cost
        edge_count += 1
    if edge_count != n-1:
        print(-1)
        return
    print(total_cost)


n, m = map(int, sys.stdin.readline().split())
node_types = [None] + sys.stdin.readline().split()
edges = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

sol(n, m, node_types, edges)
