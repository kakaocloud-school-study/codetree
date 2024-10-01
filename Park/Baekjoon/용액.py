def find_closest_to_zero_solution(values):
    n = len(values)
    left = 0
    right = n - 1
    closest_sum = float('inf')
    answer = (values[left], values[right])
    
    # 투 포인터 시작
    while left < right:
        current_sum = values[left] + values[right]
        
        # 현재 합이 0에 더 가까운 경우 갱신
        if abs(current_sum) < abs(closest_sum):
            closest_sum = current_sum
            answer = (values[left], values[right])
        
        # 합이 양수면 right를 왼쪽으로 이동
        if current_sum > 0:
            right -= 1
        # 합이 음수면 left를 오른쪽으로 이동
        elif current_sum < 0:
            left += 1
        else:
            # current_sum이 정확히 0이면 바로 종료
            break
    
    # 오름차순으로 출력
    print(answer[0], answer[1])

# 입력 받기
n = int(input().strip())
values = list(map(int, input().strip().split()))

# 문제 해결 함수 호출
find_closest_to_zero_solution(values)
