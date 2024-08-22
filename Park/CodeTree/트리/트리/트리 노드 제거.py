# 입력 값 받기
n = int(input())
par = list(map(int, input().split()))
del_node = int(input())

# 변수 초기화
root = -1
edges = [[] for _ in range(n)]
is_deleted = [False] * n
leaf_count = 0  # 리프 노드 개수를 세기 위한 변수

# 부모 정보로부터 트리 구조를 형성
for node in range(n):
    parent = par[node]
    
    if parent == -1:  # 루트 노드 확인
        root = node
    else:
        edges[parent].append(node)

# 노드 삭제 처리
is_deleted[del_node] = True

# DFS로 리프 노드 카운트
def count_leaves(node):
    global leaf_count
    
    if is_deleted[node]:  # 삭제된 노드는 처리하지 않음
        return
    
    # 리프 노드 여부 판단
    is_leaf = True
    
    for child in edges[node]:
        if not is_deleted[child]:
            is_leaf = False  # 자식이 있는 경우 리프가 아님
            count_leaves(child)  # 자식 노드에 대해 재귀적으로 탐색
    
    if is_leaf:
        leaf_count += 1  # 리프 노드라면 카운트 증가

# 루트 노드에서 DFS 시작
if not is_deleted[root]:  # 루트가 삭제되지 않았을 때만 탐색 시작
    count_leaves(root)

# 리프 노드의 개수 출력
print(leaf_count)
