import heapq
import sys

input = sys.stdin.read

def dijkstra(n, graph, start):
    distances = [float('inf')] * (n + 1)
    distances[start] = 0
    queue = [(0, start)] # (거리, 노드)
    
    while queue:
        current_distance, current_node = heapq.heappop(queue)
        
        if current_distance > distances[current_node]:
            continue
        
        for neighbor, weight in graph[current_node]:
            distance = current_distance + weight
            
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(queue, (distance, neighbor))
                
    return distances

def main():
    data = input().split()
    n = int(data[0])
    m = int(data[1])
    x = int(data[2])
    
    graph = [[] for _ in range(n + 1)]
    reverse_graph = [[] for _ in range(n + 1)]
    
    index = 3
    for _ in range(m):
        u = int(data[index])
        v = int(data[index + 1])
        t = int(data[index + 2])
        graph[u].append((v, t))
        reverse_graph[v].append((u, t))
        index += 3
    
    # X 마을로 가는 최단 시간
    to_party = dijkstra(n, graph, x)
    
    # X 마을에서 오는 최단 시간
    from_party = dijkstra(n, reverse_graph, x)
    
    # 왕복 시간 계산
    max_time = 0
    for i in range(1, n + 1):
        round_trip_time = to_party[i] + from_party[i]
        if round_trip_time > max_time:
            max_time = round_trip_time
    
    print(max_time)

if __name__ == "__main__":
    main()
