'''
x, y, z 각각 축에 대해서 간선을 구한다
축별로 정렬하고 순서대로 인접점과의 차를 구하고 간선으로 저장한다. 인접점 너머의 점을 사용해서 최소가 되는 경우는 없다.
'''
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


def sol(n, points):
    edges = []
    points.sort(key=lambda x: x[1])
    for i in range(n-1):
        diff = points[i+1][1] - points[i][1]
        edges.append((points[i][0], points[i+1][0], diff))
    points.sort(key=lambda x: x[2])
    for i in range(n-1):
        diff = points[i+1][2] - points[i][2]
        edges.append((points[i][0], points[i+1][0], diff))
    points.sort(key=lambda x: x[3])
    for i in range(n-1):
        diff = points[i+1][3] - points[i][3]
        edges.append((points[i][0], points[i+1][0], diff))

    edges.sort(key=lambda x: x[2])
    kruskal(n, edges)


n = int(sys.stdin.readline())
points = [[id] + list(map(int, sys.stdin.readline().split()))
          for id in range(n)]

sol(n, points)
