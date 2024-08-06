def flip(state, i):
    # 전구 상태를 바꾸는 함수
    n = len(state)
    if i > 0:
        state[i-1] = 1 - state[i-1]
    state[i] = 1 - state[i]
    if i < n - 1:
        state[i+1] = 1 - state[i+1]

def get_min_switches(N, current_state, target_state):
    import copy

    def count_switches(initial_press):
        state = copy.deepcopy(current_state)
        switches = 0
        
        if initial_press:
            flip(state, 0)
            switches += 1

        for i in range(1, N):
            if state[i-1] != target_state[i-1]:
                flip(state, i)
                switches += 1

        if state == target_state:
            return switches
        else:
            return float('inf')

    # 첫 스위치를 누르지 않는 경우와 누르는 경우를 각각 계산
    result_without_first_press = count_switches(False)
    result_with_first_press = count_switches(True)
    
    result = min(result_without_first_press, result_with_first_press)

    if result == float('inf'):
        return -1
    else:
        return result

# 입력
N = int(input())
current_state = list(map(int, list(input().strip())))
target_state = list(map(int, list(input().strip())))

# 최소 스위치 수 계산
result = get_min_switches(N, current_state, target_state)

# 출력
print(result)
