import sys
sys.setrecursionlimit(100000)

# 입력 값 받기
n = int(input())
edges = [[] for _ in range(n + 1)]  # 간선 정보를 저장할 리스트
parent = [0] * (n + 1)  # 각 노드의 부모를 저장할 리스트

# n - 1개의 간선 정보를 입력받음
for _ in range(n - 1):
    x, y = map(int, input().split())
    edges[x].append(y)
    edges[y].append(x)

# DFS를 사용하여 트리의 부모를 찾는 함수
def find_parents(node, parent_node):
    parent[node] = parent_node  # 현재 노드의 부모 저장
    for neighbor in edges[node]:
        if neighbor != parent_node:  # 방문하지 않은 노드라면 탐색
            find_parents(neighbor, node)

# 1번 노드를 시작으로 DFS 탐색
find_parents(1, 0)

# 2번 노드부터 각 노드의 부모 출력
for i in range(2, n + 1):
    print(parent[i])
