'''
기본문제에 중복 간선 추가한 문제
그냥 중복 간선은 최소 거리 간선만 남기면 됨
'''

import heapq
import sys
from collections import defaultdict


def sol(n, m, s_node, e_node, graph):
    min_dists = [sys.maxsize] * (n+1)
    min_dists[s_node] = 0
    hq = [(0, s_node)]
    while len(hq):
        cost, node = heapq.heappop(hq)
        if cost > min_dists[node]:
            continue
        for n_node in graph[node]:
            if min_dists[n_node] > cost + graph[node][n_node]:
                min_dists[n_node] = cost + graph[node][n_node]
                heapq.heappush(hq, (min_dists[n_node], n_node))
    print(min_dists[e_node])


n, m = map(int, sys.stdin.readline().split())
graph = defaultdict(lambda: defaultdict(lambda: sys.maxsize))
for _ in range(m):
    s, e, c = map(int, sys.stdin.readline().split())
    graph[s][e] = min(graph[s][e], c)
    graph[e][s] = min(graph[e][s], c)
s_node, e_node = map(int, sys.stdin.readline().split())

sol(n, m, s_node, e_node, graph)
