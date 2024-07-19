'''
한 노선 안에
3 4 6 2 5
라는 정류장이 있는 경우
(3, 4), (3, 6), (3, 2), (3, 5),
(4, 6), (4, 2), (4, 5),
(6, 2), (6, 5),
(2, 5) 
의 간선이 생김

또한 최소 비용이 아니라 최소 비용과 그때의 거리를 구하고 비용이 같다면 최소 거리를 출력해야 하므로
(비용, 거리) 튜플의 최소를 구해야 한다
'''

import heapq
import sys
from collections import defaultdict


def sol(s_node, e_node, graph):
    min_costs = [sys.maxsize] * (1001)
    min_costs[s_node] = 0
    dists = [sys.maxsize] * (1001)
    dists[s_node] = 0
    hq = [(0, 0, s_node)]
    while len(hq):
        cost, dist, node = heapq.heappop(hq)
        if (cost, dist) > (min_costs[node], dists[node]):
            continue
        for n_node in graph[node]:
            addtional_cost, addtional_dist = graph[node][n_node]
            if (min_costs[n_node], dists[n_node]) > (cost + addtional_cost, dist + addtional_dist):
                min_costs[n_node] = cost + addtional_cost
                dists[n_node] = dist + addtional_dist
                heapq.heappush(hq, (min_costs[n_node], dists[n_node], n_node))
    if min_costs[e_node] == sys.maxsize:
        print(-1, -1)
        return
    print(min_costs[e_node], dists[e_node])


s_node, e_node, n = map(int, sys.stdin.readline().split())
graph = defaultdict(lambda: defaultdict(lambda: (sys.maxsize, sys.maxsize)))
for _ in range(n):
    cost, _ = map(int, sys.stdin.readline().split())
    stations = list(map(int, sys.stdin.readline().split()))
    for i in range(len(stations)):
        s = stations[i]
        for j in range(i+1, len(stations)):
            e = stations[j]
            graph[s][e] = min(graph[s][e], (cost, j-i))

sol(s_node, e_node, graph)
