def find_cycles(n, table):
    visited = [False] * (n + 1)
    cycle_nodes = set()

    def dfs(start, path):
        if visited[start]:
            if start in path:
                # 사이클 발견, 현재 경로에서 사이클 부분만 추출
                cycle_start_index = path.index(start)
                cycle_nodes.update(path[cycle_start_index:])
            return
        
        visited[start] = True
        path.append(start)
        next_node = table[start]
        dfs(next_node, path)
        path.pop()

    # 모든 노드에서 DFS를 시작하여 사이클 찾기
    for i in range(1, n + 1):
        if not visited[i]:
            dfs(i, [])
    
    return cycle_nodes

# 입력 처리
n = int(input())
table = [0] + [int(input()) for _ in range(n)]  # 1-based index를 위해 앞에 0 추가

# 사이클 찾기 및 출력
cycle_nodes = find_cycles(n, table)
result = sorted(cycle_nodes)

# 결과 출력
print(len(result))
for num in result:
    print(num)
