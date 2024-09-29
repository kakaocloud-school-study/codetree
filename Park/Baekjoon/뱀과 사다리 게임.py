from collections import deque

def min_dice_throws(N, M, ladders, snakes):
    # 게임판 설정 (1부터 100까지)
    board = list(range(101))
    
    # 사다리와 뱀 정보 설정
    for x, y in ladders:
        board[x] = y
    for u, v in snakes:
        board[u] = v
    
    # BFS 탐색을 위한 큐와 방문 여부 체크 배열
    queue = deque([(1, 0)])  # (현재 위치, 주사위 굴린 횟수)
    visited = [False] * 101
    visited[1] = True
    
    # BFS 시작
    while queue:
        current, moves = queue.popleft()
        
        # 100번 칸에 도착한 경우 최소 횟수 반환
        if current == 100:
            return moves
        
        # 주사위를 굴려서 이동
        for dice in range(1, 7):
            next_pos = current + dice
            if next_pos <= 100:
                final_pos = board[next_pos]  # 사다리나 뱀이 있으면 이동한 위치
                if not visited[final_pos]:
                    visited[final_pos] = True
                    queue.append((final_pos, moves + 1))
                    
    return -1  # 만약 도달할 수 없는 경우 (문제 조건상 도달할 수 있음)

# 입력 처리
N, M = map(int, input().split())
ladders = [tuple(map(int, input().split())) for _ in range(N)]
snakes = [tuple(map(int, input().split())) for _ in range(M)]

# 결과 출력
print(min_dice_throws(N, M, ladders, snakes))
