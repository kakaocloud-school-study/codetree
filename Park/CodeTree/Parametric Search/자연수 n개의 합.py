def max_n(s):
    left = 1
    right = s
    max_num = 0

    while left <= right:
        mid = (left + right) // 2
        if mid * (mid + 1) // 2 <= s:  # 1부터 mid까지의 합이 s 이하인 경우
            left = mid + 1
            max_num = mid  # 현재 mid가 가능한 n의 후보이므로 max_num을 갱신
        else:
            right = mid - 1  # s를 초과하는 경우

    return max_num

# 예제 입력
s = int(input())
# 최대 n 값을 구하고 출력
print(max_n(s))
