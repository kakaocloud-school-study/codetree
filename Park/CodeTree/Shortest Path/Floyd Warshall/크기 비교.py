# 변수 선언 및 입력
n, m = map(int, input().split())

# 그래프 인접행렬 초기화 (0으로 설정)
comparison_graph = [[0] * (n + 1) for _ in range(n + 1)]

# 간선 정보 입력
for _ in range(m):
    a, b = map(int, input().split())
    # a > b 관계이므로 1로 설정
    comparison_graph[a][b] = 1

# 플로이드-워셜 알고리즘을 통해 모든 쌍의 비교 결과 유추
for k in range(1, n + 1):  # 경유지 k
    for i in range(1, n + 1):  # 출발지 i
        for j in range(1, n + 1):  # 도착지 j
            # i -> k 그리고 k -> j가 가능하면 i -> j도 가능
            if comparison_graph[i][k] and comparison_graph[k][j]:
                comparison_graph[i][j] = 1

# 각 정수마다 크기 비교 결과를 추론할 수 없는 정수의 개수를 출력
for i in range(1, n + 1):
    unknown_count = 0
    for j in range(1, n + 1):
        if i == j:  # 자기 자신과 비교는 패스
            continue
        # i와 j 중 누가 큰지 알 수 없는 경우
        if not comparison_graph[i][j] and not comparison_graph[j][i]:
            unknown_count += 1
    print(unknown_count)
