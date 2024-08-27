from collections import deque

# 방향벡터 상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(n, m, graph):
    # 3차원 리스트 생성: dist[x][y][z] -> z가 0이면 벽을 안 부순 상태, 1이면 벽을 부순 상태
    dist = [[[0] * 2 for _ in range(m)] for _ in range(n)]
    
    # 시작 위치
    queue = deque([(0, 0, 0)])  # (x, y, 벽 부쉈는지 여부)
    dist[0][0][0] = 1  # 시작점 거리 초기화
    
    while queue:
        x, y, wall_broken = queue.popleft()
        
        # 도착점에 도달했을 경우
        if x == n - 1 and y == m - 1:
            return dist[x][y][wall_broken]
        
        # 상하좌우 탐색
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            # 범위 내에 있는지 체크
            if 0 <= nx < n and 0 <= ny < m:
                # 벽이 없고 아직 방문하지 않은 곳일 때
                if graph[nx][ny] == 0 and dist[nx][ny][wall_broken] == 0:
                    dist[nx][ny][wall_broken] = dist[x][y][wall_broken] + 1
                    queue.append((nx, ny, wall_broken))
                
                # 벽이 있고, 벽을 아직 부수지 않았을 때
                if graph[nx][ny] == 1 and wall_broken == 0 and dist[nx][ny][1] == 0:
                    dist[nx][ny][1] = dist[x][y][wall_broken] + 1
                    queue.append((nx, ny, 1))
    
    # 도착점에 도달할 수 없는 경우
    return -1

# 입력 처리
n, m = map(int, input().split())
graph = [list(map(int, input().strip())) for _ in range(n)]

# BFS 실행 및 결과 출력
print(bfs(n, m, graph))
