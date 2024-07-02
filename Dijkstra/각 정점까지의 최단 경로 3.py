import sys
import heapq

INT_MAX = sys.maxsize

# 입력 받기
n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]

# 그래프 초기화
for _ in range(m):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

# 다익스트라 알고리즘
def dijkstra(start):
    dist = [INT_MAX] * (n + 1)
    dist[start] = 0
    pq = [(0, start)]  # (거리, 정점) 형태의 우선순위 큐
    
    while pq:
        current_dist, u = heapq.heappop(pq)
        
        if current_dist > dist[u]:
            continue
        
        for v, weight in graph[u]:
            distance = current_dist + weight
            if distance < dist[v]:
                dist[v] = distance
                heapq.heappush(pq, (distance, v))
    
    return dist

# 1번 정점에서 시작
distances_from_1 = dijkstra(1)

# 결과 출력
for i in range(2, n + 1):
    if distances_from_1[i] == INT_MAX:
        print(-1)
    else:
        print(distances_from_1[i])
