import heapq
import sys
from collections import defaultdict


def sol(n, m, graph):
    min_dists = [sys.maxsize] * (n+1)
    min_dists[1] = 0
    hq = [(0, 1)]
    while len(hq):
        cost, node = heapq.heappop(hq)
        if cost > min_dists[node]:
            continue
        for n_node in graph[node]:
            if min_dists[n_node] > cost + graph[node][n_node]:
                min_dists[n_node] = cost + graph[node][n_node]
                heapq.heappush(hq, (min_dists[n_node], n_node))
    for node in range(2, n+1):
        print(min_dists[node] if min_dists[node] != sys.maxsize else -1)


n, m = map(int, sys.stdin.readline().split())
graph = defaultdict(dict)
for _ in range(m):
    s, e, c = map(int, sys.stdin.readline().split())
    graph[s][e] = c

sol(n, m, graph)
