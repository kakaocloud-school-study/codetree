def longest_subsequence(N, K, sequence):
    from collections import defaultdict

    count_map = defaultdict(int)
    left = 0
    max_length = 0

    for right in range(N):
        count_map[sequence[right]] += 1
        
        while count_map[sequence[right]] > K:
            count_map[sequence[left]] -= 1
            left += 1
        
        max_length = max(max_length, right - left + 1)

    return max_length

# 입력 받기
N, K = map(int, input().split())
sequence = list(map(int, input().split()))

# 결과 출력
print(longest_subsequence(N, K, sequence))
