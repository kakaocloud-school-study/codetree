from collections import deque

def find_fastest_time(N, K):
    # 수빈이와 동생의 위치가 같은 경우
    if N == K:
        return 0
    
    # 최대 범위 설정
    max_range = 100000
    
    # 방문 여부를 체크하는 배열과 거리 배열
    visited = [False] * (max_range + 1)
    dist = [0] * (max_range + 1)
    
    # BFS를 위한 큐 설정
    queue = deque([N])
    visited[N] = True
    
    while queue:
        current = queue.popleft()
        
        # 3가지 이동 방법을 확인
        for next_pos in (current - 1, current + 1, 2 * current):
            if 0 <= next_pos <= max_range and not visited[next_pos]:
                visited[next_pos] = True
                dist[next_pos] = dist[current] + 1
                queue.append(next_pos)
                
                # 동생을 찾은 경우
                if next_pos == K:
                    return dist[next_pos]
    
    return -1  # 이론상 도달하지 않음

# 예제 입력
N, K = map(int, input().split())

# 결과 출력
print(find_fastest_time(N, K))
