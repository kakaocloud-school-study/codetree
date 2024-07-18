# 변수 선언 및 입력
n, m = tuple(map(int, input().split()))
combination = []

# 방문한 원소들을 출력해줍니다.
def print_combination():
    for elem in combination:
        print(elem, end=" ")
    print()

# 조합을 찾는 함수
def find_combination(start):
    if len(combination) == m:  # 조합의 길이가 m이면 출력
        print_combination()
        return

    for num in range(start, n + 1):
        combination.append(num)  # 현재 숫자를 추가
        find_combination(num + 1)  # 다음 숫자로 재귀 호출
        combination.pop()  # 현재 숫자를 제거

# 조합 탐색 시작
find_combination(1)
