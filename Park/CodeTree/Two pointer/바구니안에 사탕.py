# 변수 선언 및 입력 처리
n, k = map(int, input().split())  # n: 상자의 개수, k: 구간의 절반 크기
candies = [(-1, -1)]  # 인덱스 관리를 위해 0번은 사용하지 않음

# 사탕 상자 정보를 입력 받음
for _ in range(n):
    count, position = map(int, input().split())
    # 위치 순으로 정렬하기 위해 (위치, 사탕 수) 형태로 저장
    candies.append((position, count))


# 사탕 상자의 위치를 반환하는 함수
def get_position_of_box(box_index):
    position, _ = candies[box_index]
    return position


# 사탕 상자의 사탕 수를 반환하는 함수
def get_candy_count_in_box(box_index):
    _, count = candies[box_index]
    return count


# 위치 기준으로 오름차순 정렬
candies.sort()

# 최대 사탕 수를 저장할 변수 초기화
max_candies = 0

# 구간 내 사탕 수를 저장할 변수
current_total_candies = 0
right_pointer = 0  # 구간의 오른쪽 끝을 가리키는 포인터

# 왼쪽 포인터를 하나씩 이동하면서 구간을 탐색
for left_pointer in range(1, n + 1):
    # 구간의 크기가 2K보다 같거나 작은 경우에 한해 오른쪽 포인터를 이동
    while right_pointer + 1 <= n and get_position_of_box(right_pointer + 1) - get_position_of_box(left_pointer) <= 2 * k:
        right_pointer += 1
        current_total_candies += get_candy_count_in_box(right_pointer)

    # 현재 구간 내의 사탕 수 중 최대값을 갱신
    max_candies = max(max_candies, current_total_candies)

    # 다음 구간으로 넘어가기 전에 왼쪽 포인터가 가리키는 상자의 사탕을 빼줌
    current_total_candies -= get_candy_count_in_box(left_pointer)

# 결과 출력
print(max_candies)
