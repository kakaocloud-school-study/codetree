from bisect import bisect_left

def min_moves_to_sort(N, numbers):
    lis = []

    for num in numbers:
        pos = bisect_left(lis, num)  # LIS에서 num이 들어갈 위치를 찾음
        if pos < len(lis):
            lis[pos] = num  # 해당 위치에 num을 대체
        else:
            lis.append(num)  # num을 LIS에 추가

    return N - len(lis)  # 전체 N에서 LIS 길이를 뺀 것이 최소 이동 수

# 입력 받기
N = int(input())
numbers = [int(input()) for _ in range(N)]

# 결과 출력
print(min_moves_to_sort(N, numbers))
