# 변수 선언 및 입력
n, m = map(int, input().split())

# 그래프를 딕셔너리로 선언
graph = {i: [] for i in range(1, n + 1)}
visited = [False] * (n + 1)
vertex_cnt = 0

def dfs(vertex):
    global vertex_cnt
    
    # 현재 정점을 방문 처리
    visited[vertex] = True
    vertex_cnt += 1
    
    # 연결된 모든 정점 탐색
    for neighbor in graph[vertex]:
        if not visited[neighbor]:
            dfs(neighbor)
    
# 간선 정보 입력
for _ in range(m):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

# DFS 시작
dfs(1)

print(vertex_cnt - 1)  # 시작 정점을 제외한 방문한 정점의 수
