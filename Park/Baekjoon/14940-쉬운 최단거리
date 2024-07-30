from collections import deque

def find_distances(n, m, grid):
    # 이동 방향 (상, 하, 좌, 우)
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    # 목표지점 찾기
    target = None
    for i in range(n):
        for j in range(m):
            if grid[i][j] == 2:
                target = (i, j)
                break
        if target:
            break
    
    # BFS 초기 설정
    queue = deque([target])
    distances = [[-1] * m for _ in range(n)]
    distances[target[0]][target[1]] = 0
    
    # BFS 실행
    while queue:
        x, y = queue.popleft()
        current_distance = distances[x][y]
        
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and grid[nx][ny] == 1 and distances[nx][ny] == -1:
                distances[nx][ny] = current_distance + 1
                queue.append((nx, ny))
    
    # 결과 출력 형식에 맞게 조정
    for i in range(n):
        for j in range(m):
            if grid[i][j] == 0:
                distances[i][j] = 0
            elif grid[i][j] == 1 and distances[i][j] == -1:
                distances[i][j] = -1
    
    return distances

# 입력 받기
n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# 거리 계산
distances = find_distances(n, m, grid)

# 출력
for row in distances:
    print(" ".join(map(str, row)))
