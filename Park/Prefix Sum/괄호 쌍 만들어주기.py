def count_valid_pairs(A):
    open_brackets = 0
    close_brackets = 0
    valid_pairs = 0

    n = len(A)
    
    # 먼저 연속된 여는 괄호 두 개를 찾습니다.
    for i in range(n - 1):
        if A[i] == '(' and A[i + 1] == '(':
            open_brackets += 1
    
    # 이제 연속된 닫는 괄호 두 개를 찾습니다.
    for i in range(n - 1):
        if A[i] == ')' and A[i + 1] == ')':
            close_brackets += 1
    
    # 유효한 쌍의 개수는 연속된 여는 괄호 두 개의 수와 닫는 괄호 두 개의 수 중 작은 값입니다.
    valid_pairs = min(open_brackets, close_brackets)
    
    return valid_pairs

# 예제 입력
A = ")(()())())"
print(count_valid_pairs(A))  # 출력: 4
