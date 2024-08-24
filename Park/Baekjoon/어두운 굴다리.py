def is_possible(height, positions, N):
    # 첫 번째 가로등이 커버할 수 있는 범위
    if positions[0] - height > 0:
        return False

    # 각 가로등이 커버할 수 있는 범위를 확인
    for i in range(1, len(positions)):
        if positions[i-1] + height < positions[i] - height:
            return False
    
    # 마지막 가로등이 커버할 수 있는 범위
    if positions[-1] + height < N:
        return False

    return True

def find_min_height(N, M, positions):
    left, right = 1, N
    result = N
    
    while left <= right:
        mid = (left + right) // 2
        if is_possible(mid, positions, N):
            result = mid
            right = mid - 1
        else:
            left = mid + 1
            
    return result

# 입력
N = int(input())  # 굴다리의 길이
M = int(input())  # 가로등의 개수
positions = list(map(int, input().split()))  # 가로등의 위치들

# 최소 높이 출력
print(find_min_height(N, M, positions))
