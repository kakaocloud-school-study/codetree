from sortedcontainers import SortedSet

# 입력받을 변수 선언
c, n = map(int, input().split())
red_stones = [int(input()) for _ in range(c)]

black_stones = []
for _ in range(n):
    a, b = map(int, input().split())
    black_stones.append((b, a))

# 빨간 돌을 저장할 정렬된 집합 생성
red_sorted_set = SortedSet(red_stones)

# 검은 돌을 b 기준으로 오름차순 정렬
black_stones.sort()

# 매칭 가능한 돌의 개수 초기화
match_count = 0

# b가 작은 돌부터 a보다 같거나 큰 최소 Ti를 찾기.
for b_value, a_value in black_stones:
    # a_value보다 같거나 큰 값의 인덱스를 찾기.
    idx = red_sorted_set.bisect_left(a_value)
    
    # 인덱스가 집합의 크기를 벗어나지 않는 경우
    if idx < len(red_sorted_set):
        selected_ti = red_sorted_set[idx]
        
        # 선택한 Ti가 b_value보다 작거나 같다면 매칭 진행
        if selected_ti <= b_value:
            match_count += 1
            red_sorted_set.remove(selected_ti)

# 결과 출력
print(match_count)
