def allocate_budget(requests, total_budget):
    # 이분 탐색을 위한 변수 초기화
    left, right = 0, max(requests)
    answer = 0
    
    while left <= right:
        mid = (left + right) // 2
        allocated = sum(min(request, mid) for request in requests)
        
        if allocated <= total_budget:
            answer = mid
            left = mid + 1
        else:
            right = mid - 1
            
    return answer

# 입력 받기
N = int(input())  # 지방의 수
requests = list(map(int, input().split()))  # 각 지방의 예산 요청
total_budget = int(input())  # 총 예산

# 결과 출력
print(allocate_budget(requests, total_budget))
