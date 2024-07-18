def max_sum_of_k_elements(n, k, arr):
    # 초기 윈도우의 합 계산
    current_sum = sum(arr[:k])
    max_sum = current_sum
    
    # 최대 합 계산
    for i in range(1, n - k + 1):
        current_sum = current_sum - arr[i - 1] + arr[i + k - 1]
        if current_sum > max_sum:
            max_sum = current_sum
    
    return max_sum

# 입력 받기
n, k = map(int, input().split())
arr = list(map(int, input().split()))

# 결과 출력
print(max_sum_of_k_elements(n, k, arr))
