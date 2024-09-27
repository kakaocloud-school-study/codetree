import heapq
import sys
input = sys.stdin.readline
INF = float('inf')

# 입력 받기
N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

# 그래프 구축
for _ in range(M):
    A, B, C = map(int, input().split())
    graph[A].append((B, C))
    graph[B].append((A, C))

# 다익스트라 알고리즘
def dijkstra(start):
    # 소들의 수의 최소 합을 저장할 배열, 무한대로 초기화
    distance = [INF] * (N + 1)
    distance[start] = 0
    
    # 우선순위 큐 (비용, 노드)
    pq = []
    heapq.heappush(pq, (0, start))
    
    while pq:
        # 현재 노드까지의 비용과 노드 번호
        current_cost, current_node = heapq.heappop(pq)
        
        # 이미 처리된 노드인 경우 무시
        if current_cost > distance[current_node]:
            continue
        
        # 인접한 노드 확인
        for neighbor, weight in graph[current_node]:
            cost = current_cost + weight
            # 현재 노드를 거쳐서 인접한 노드로 가는 비용이 더 적은 경우 업데이트
            if cost < distance[neighbor]:
                distance[neighbor] = cost
                heapq.heappush(pq, (cost, neighbor))
    
    return distance

# 헛간 1에서 헛간 N까지의 최소 비용 계산
min_cost = dijkstra(1)[N]

print(min_cost)
