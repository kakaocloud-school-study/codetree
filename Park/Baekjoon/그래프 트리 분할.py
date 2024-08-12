from collections import defaultdict, deque

def split_graph_into_two_trees(N, M, edges):
    # 그래프를 인접 리스트로 표현
    graph = defaultdict(list)
    edge_list = {}
    for i, (u, v) in enumerate(edges):
        graph[u].append(v)
        graph[v].append(u)
        edge_list[(u, v)] = i + 1
        edge_list[(v, u)] = i + 1
    
    # 방문 여부와 연결 요소 정보 저장
    visited = [False] * (N + 1)
    components = []

    def bfs(start):
        queue = deque([start])
        visited[start] = True
        component_nodes = []
        component_edges = []
        
        while queue:
            node = queue.popleft()
            component_nodes.append(node)
            for neighbor in graph[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)
                    component_edges.append(edge_list[(node, neighbor)])
        
        return component_nodes, component_edges

    # 모든 정점에 대해 연결 요소 찾기
    for node in range(1, N + 1):
        if not visited[node]:
            component_nodes, component_edges = bfs(node)
            components.append((component_nodes, component_edges))

    # 연결 요소가 두 개 이상인 경우에만 분리 가능
    if len(components) < 2:
        return -1

    # 가장 큰 두 개의 연결 요소 선택
    components.sort(key=lambda x: len(x[0]), reverse=True)
    first_tree, second_tree = components[0], components[1]
    
    N1, N2 = len(first_tree[0]), len(second_tree[0])
    result = [
        f"{N1} {N2}",
        " ".join(map(str, first_tree[0])),
        " ".join(map(str, first_tree[1])),
        " ".join(map(str, second_tree[0])),
        " ".join(map(str, second_tree[1])),
    ]
    
    return "\n".join(result)

# 입력 예제
N, M = 5, 5
edges = [(1, 2), (1, 3), (2, 3), (3, 4), (4, 5)]

# 함수 호출 및 결과 출력
result = split_graph_into_two_trees(N, M, edges)
print(result)
