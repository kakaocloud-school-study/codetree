from collections import deque

# 상, 하, 좌, 우 이동을 위한 델타 값
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def escape_maze(R, C, maze):
    fire_queue = deque()
    jihun_queue = deque()
    fire_time = [[-1] * C for _ in range(R)]
    jihun_time = [[-1] * C for _ in range(R)]

    # 초기 위치 파악
    for i in range(R):
        for j in range(C):
            if maze[i][j] == 'F':
                fire_queue.append((i, j))
                fire_time[i][j] = 0
            elif maze[i][j] == 'J':
                jihun_queue.append((i, j))
                jihun_time[i][j] = 0

    # 불의 확산 시간 계산
    while fire_queue:
        x, y = fire_queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < R and 0 <= ny < C and maze[nx][ny] == '.' and fire_time[nx][ny] == -1:
                fire_time[nx][ny] = fire_time[x][y] + 1
                fire_queue.append((nx, ny))

    # 지훈이의 탈출 시간 계산
    while jihun_queue:
        x, y = jihun_queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            # 미로의 가장자리에 도달한 경우 탈출 성공
            if nx < 0 or nx >= R or ny < 0 or ny >= C:
                return jihun_time[x][y] + 1
            if maze[nx][ny] == '.' and jihun_time[nx][ny] == -1:
                # 불이 아직 도달하지 않았거나, 지훈이가 불보다 먼저 도착하는 경우
                if fire_time[nx][ny] == -1 or jihun_time[x][y] + 1 < fire_time[nx][ny]:
                    jihun_time[nx][ny] = jihun_time[x][y] + 1
                    jihun_queue.append((nx, ny))

    return "IMPOSSIBLE"

# 입력 받기
R, C = map(int, input().split())
maze = [input().strip() for _ in range(R)]

# 결과 출력
print(escape_maze(R, C, maze))
