# 입력을 받아서 트리 구조만들기
n = int(input("노드의 개수를 입력하세요: "))  # 노드 개수 입력
tree = {}  # 트리 구조를 저장할 딕셔너리

# 노드 정보 입력 및 트리 구성
for _ in range(n):
    x, l, r = input().split()  # 노드 x, 왼쪽 자식 l, 오른쪽 자식 r 입력
    tree[x] = (l, r)  # 트리의 각 노드에 대한 자식 정보 저장

# 전위 순회 함수
def pre_order(node):
    if node == '.':  # 자식이 없으면 종료
        return

    print(node, end="")  # 현재 노드 출력
    pre_order(tree[node][0])  # 왼쪽 자식 순회
    pre_order(tree[node][1])  # 오른쪽 자식 순회

# 중위 순회 함수
def in_order(node):
    if node == '.':  # 자식이 없으면 종료
        return

    in_order(tree[node][0])  # 왼쪽 자식 순회
    print(node, end="")  # 현재 노드 출력
    in_order(tree[node][1])  # 오른쪽 자식 순회

# 후위 순회 함수
def post_order(node):
    if node == '.':  # 자식이 없으면 종료
        return

    post_order(tree[node][0])  # 왼쪽 자식 순회
    post_order(tree[node][1])  # 오른쪽 자식 순회
    print(node, end="")  # 현재 노드 출력

# 각 순회별 결과 출력
pre_order('A')
print()
in_order('A')
print()
post_order('A')
print()
