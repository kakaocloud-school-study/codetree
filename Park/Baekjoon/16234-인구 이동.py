from collections import deque

def bfs(x, y, visited, A, N, L, R):
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # 상하좌우 방향 설정
    queue = deque([(x, y)])  # BFS를 위한 큐 초기화
    union = [(x, y)]  # 연합 국가 리스트 초기화
    visited[x][y] = True  # 현재 국가 방문 표시
    population_sum = A[x][y]  # 연합 인구 합계 초기화
    
    while queue:
        cx, cy = queue.popleft()  # 큐에서 현재 위치 꺼내기
        
        for dx, dy in directions:
            nx, ny = cx + dx, cy + dy  # 인접 위치 계산
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:  # 유효한 범위 내에 있고 방문하지 않은 경우
                if L <= abs(A[cx][cy] - A[nx][ny]) <= R:  # 인구 차이가 조건에 맞는 경우
                    visited[nx][ny] = True  # 방문 표시
                    queue.append((nx, ny))  # 큐에 추가
                    union.append((nx, ny))  # 연합에 추가
                    population_sum += A[nx][ny]  # 인구 합계 업데이트
                    
    return union, population_sum // len(union)  # 연합 국가 리스트와 새로운 인구 수 반환

def simulate_population_movement(N, L, R, A):
    days = 0  # 인구 이동 일수 초기화
    while True:
        visited = [[False] * N for _ in range(N)]  # 방문 표시 초기화
        movement_occurred = False  # 인구 이동 발생 여부 초기화
        
        for i in range(N):
            for j in range(N):
                if not visited[i][j]:  # 아직 방문하지 않은 국가인 경우
                    union, new_population = bfs(i, j, visited, A, N, L, R)  # BFS로 연합 찾기
                    if len(union) > 1:  # 연합이 두 개 이상의 국가로 이루어진 경우
                        movement_occurred = True  # 인구 이동 발생 표시
                        for x, y in union:
                            A[x][y] = new_population  # 연합 국가들의 인구 수 업데이트
                        
        if not movement_occurred:  # 인구 이동이 더 이상 발생하지 않는 경우
            break
        days += 1  # 하루 증가
    
    return days  # 인구 이동 일수 반환

# 입력 받기
N, L, R = map(int, input().split())  # N, L, R 값 입력 받기
A = [list(map(int, input().split())) for _ in range(N)]  # 각 국가의 인구 수 입력 받기

# 결과 출력
result = simulate_population_movement(N, L, R, A)  # 인구 이동 시뮬레이션 실행
print(result)  # 결과 출력
