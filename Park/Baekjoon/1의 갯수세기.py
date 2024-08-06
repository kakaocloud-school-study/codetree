def count_ones_in_binary(A, B):
    total_count = 0
    for x in range(A, B + 1):
        total_count += bin(x).count('1')
    return total_count

# 입력
A = 2
B = 12

# 결과 출력
result = count_ones_in_binary(A, B)
print(result)
