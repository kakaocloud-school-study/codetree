def can_transform(S, T):
    while len(T) > len(S):
        if T[-1] == 'A':
            T = T[:-1]  # 'A'를 제거
        elif T[-1] == 'B':
            T = T[:-1][::-1]  # 'B'를 제거하고 문자열을 뒤집기
        
    return 1 if T == S else 0

# 입력
S = input().strip()
T = input().strip()

# 결과 출력
print(can_transform(S, T))
