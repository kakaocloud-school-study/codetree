'''
포인터 범위 내 y값 최소 최대 점을 관리하기 위해 힙 두개를 사용함
'''
import heapq
import sys


def sol(n, d, points):
    graph = dict()
    for x, y in points:
        if graph.get(x) == None:
            graph[x] = [y]
        else:
            graph[x].append(y)
    x_values = sorted(graph.keys())

    min_q = []
    max_q = []
    for y in graph[x_values[0]]:
        heapq.heappush(min_q, (y, x_values[0]))
        heapq.heappush(max_q, (-y, x_values[0]))
    e_i = 0
    min_range = sys.maxsize
    for s_i in range(len(x_values)):
        s_x = x_values[s_i]
        while min_q[0][1] < s_x:
            heapq.heappop(min_q)
        while max_q[0][1] < s_x:
            heapq.heappop(max_q)

        while (abs(max_q[0][0]) - min_q[0][0]) < d and e_i < len(x_values) - 1:
            e_i += 1
            e_x = x_values[e_i]
            for y in graph[e_x]:
                heapq.heappush(min_q, (y, e_x))
                heapq.heappush(max_q, (-y, e_x))

        if abs(max_q[0][0]) - min_q[0][0] < d:
            break

        min_range = min(min_range, e_x - s_x)

    print(min_range if min_range != sys.maxsize else -1)


n, d = list(map(int, sys.stdin.readline().split()))
points = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(n, d, points)
