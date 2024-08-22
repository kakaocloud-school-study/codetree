# 트리의 노드 개수 n과 쿼리 개수 q 입력받기
n, q = map(int, input("노드 개수와 쿼리 개수를 입력하세요: ").split())

# 노드의 색칠 여부를 나타내는 리스트 (1-indexed 사용)
is_colored = [0] * (n + 1)


def find_last_colored_node(node):
    # 노드로 가는 경로에 있는 가장 마지막으로 색칠된 노드를 찾는 함수
    last_colored = 0  # 색칠된 노드가 없다면 0으로 반환

    while node:
        if is_colored[node]:  # 현재 노드가 색칠되어 있으면 갱신
            last_colored = node
        node //= 2  # 부모 노드로 이동

    return last_colored


# 각 쿼리마다 처리
for _ in range(q):
    target_node = int(input("색칠할 노드를 입력하세요: "))

    # 해당 노드로 가는 경로에서 가장 마지막으로 색칠된 노드를 찾음
    result = find_last_colored_node(target_node)
    print(result)  # 결과 출력

    # 경로에 색칠된 노드가 없으면 현재 노드를 색칠함
    if result == 0:
        is_colored[target_node] = 1
