import heapq

# 방향 설정: 상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

problem_number = 1

while True:
    # 동굴 크기 입력
    N = int(input())
    if N == 0:
        break
    
    # 동굴 정보 입력
    cave = [list(map(int, input().split())) for _ in range(N)]
    
    # 최소 비용 저장하는 테이블 초기화
    dist = [[float('inf')] * N for _ in range(N)]
    
    # 시작점 초기화
    dist[0][0] = cave[0][0]
    
    # 다익스트라 알고리즘을 위한 우선순위 큐 초기화
    queue = []
    heapq.heappush(queue, (cave[0][0], 0, 0))  # (비용, x, y)
    
    while queue:
        current_dist, x, y = heapq.heappop(queue)
        
        # 이미 처리된 경로라면 무시
        if current_dist > dist[x][y]:
            continue
        
        # 상하좌우 이동
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            
            # 유효한 좌표라면
            if 0 <= nx < N and 0 <= ny < N:
                new_dist = current_dist + cave[nx][ny]
                
                # 더 적은 비용으로 갈 수 있다면 갱신
                if new_dist < dist[nx][ny]:
                    dist[nx][ny] = new_dist
                    heapq.heappush(queue, (new_dist, nx, ny))
    
    # 결과 출력
    print(f"Problem {problem_number}: {dist[N-1][N-1]}")
    problem_number += 1
