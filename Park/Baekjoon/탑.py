def find_receivers(tower_heights):
    n = len(tower_heights)
    result = [0] * n  # 결과를 저장할 배열
    stack = []  # 인덱스를 저장할 스택

    for i in range(n):
        # 스택이 비어있지 않고, 현재 탑이 스택 최상단의 탑보다 높을 경우 스택을 pop
        while stack and tower_heights[stack[-1]] < tower_heights[i]:
            stack.pop()
        
        # 스택이 비어있지 않다면, 스택 최상단의 탑이 현재 탑의 레이저를 수신하는 탑
        if stack:
            result[i] = stack[-1] + 1  # 인덱스는 0부터 시작하므로 +1
        
        # 현재 탑의 인덱스를 스택에 추가
        stack.append(i)
    
    return result

# 입력 처리
n = int(input().strip())
tower_heights = list(map(int, input().strip().split()))

# 결과 계산
receivers = find_receivers(tower_heights)

# 결과 출력
print(' '.join(map(str, receivers)))
