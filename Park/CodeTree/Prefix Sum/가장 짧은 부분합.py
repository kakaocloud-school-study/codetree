def min_subarray_length(n, s, arr):
    # 초기값 설정
    start = 0
    end = 0
    current_sum = 0
    min_length = float('inf')
    
    while end < n:
        # 현재 구간의 합이 s 이상이 될 때까지 end를 증가시키며 구간 확장
        while current_sum < s and end < n:
            current_sum += arr[end]
            end += 1
        
        # 현재 구간의 합이 s 이상이 되면 start를 증가시키며 구간 축소
        while current_sum >= s and start < n:
            min_length = min(min_length, end - start)
            current_sum -= arr[start]
            start += 1
    
    # 만약 min_length가 갱신되지 않았다면 -1 반환
    return min_length if min_length != float('inf') else -1

# 입력 받기
n, s = map(int, input().split())
arr = list(map(int, input().split()))

# 함수 호출 및 결과 출력
result = min_subarray_length(n, s, arr)
print(result)
