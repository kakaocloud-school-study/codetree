'''
c의 최소값을 고정하고 다익스트라를 돌린다. 실행후 실제 최소값이 c가 아닌 경우는 갱신에 적용 안 한다
c최소값을 간선들의 c 값들로 변경시켜가며 위 과정을 진행하고 각각의 계산값들중 최소값을 구해 출력
'''

import heapq
import math
import sys
from collections import defaultdict


def calculate_value(dist, min_c):
    global x
    return dist + x / min_c


def get_min(n, c_limit, graph):
    min_values = [sys.maxsize] * (n+1)
    min_values[1] = 0
    min_cs = [sys.maxsize] * (n+1)
    min_cs[1] = sys.maxsize
    hq = [(0, 0, sys.maxsize, 1)]  # (계산값, 거리, c, 노드)
    while len(hq):
        value, dist, min_c, node = heapq.heappop(hq)
        if value > min_values[node]:
            continue
        for n_node, l, c in graph[node]:
            if c < c_limit:
                continue
            n_min_c = min(min_c, c)
            n_dist = dist + l
            n_value = calculate_value(n_dist, c_limit)
            if min_values[n_node] > n_value:
                min_values[n_node] = n_value
                min_cs[n_node] = n_min_c
                heapq.heappush(hq, (n_value, n_dist, n_min_c, n_node))
    if c_limit != min_cs[n]:
        return None
    return min_values[n]


def sol(n, m, cs, graph):
    min_value = sys.maxsize
    for c_limit in cs:
        value = get_min(n, c_limit, graph)
        if value:
            min_value = min(min_value, value)
    print(math.floor(min_value))


n, m, x = map(int, sys.stdin.readline().split())
graph = defaultdict(list)
cs = []
for _ in range(m):
    s, e, l, c = map(int, sys.stdin.readline().split())
    graph[s].append((e, l, c))
    graph[e].append((s, l, c))
    cs.append(c)

sol(n, m, cs, graph)
