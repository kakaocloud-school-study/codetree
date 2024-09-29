def string_game(T, cases):
    results = []
    
    for case in cases:
        W, K = case
        char_indices = {}
        
        # 모든 문자에 대해 인덱스 수집
        for index, char in enumerate(W):
            if char not in char_indices:
                char_indices[char] = []
            char_indices[char].append(index)
        
        min_length = float('inf')
        max_length = -1
        
        # 각 문자의 인덱스 리스트 확인
        for indices in char_indices.values():
            if len(indices) >= K:
                # K개의 부분 문자열의 길이 계산
                for i in range(len(indices) - K + 1):
                    length = indices[i + K - 1] - indices[i] + 1
                    min_length = min(min_length, length)
                    
                    # 가장 긴 부분 문자열 찾기 (양끝이 동일한 경우)
                    if W[indices[i]] == W[indices[i + K - 1]]:
                        max_length = max(max_length, length)
        
        # 결과 저장
        if min_length == float('inf'):
            results.append("-1")
        else:
            results.append(f"{min_length} {max_length}")
    
    return "\n".join(results)

# 입력 처리
T = int(input().strip())
cases = [tuple(input().strip() for _ in range(2)) for _ in range(T)]
K_cases = [(W, int(K)) for W, K in cases]

# 결과 출력
print(string_game(T, K_cases))
