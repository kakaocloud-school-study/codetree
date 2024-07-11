# 입력을 받아 변수에 저장
k, n = tuple(map(int, input().split()))
selected_nums = []

# 선택된 숫자들을 출력
def print_permutation():
    for num in selected_nums:
        print(num, end=" ")
    print()

# 순열을 찾는 함수
def find_permutations(cnt):
    if cnt == n:
        print_permutation()
        return
    
    for i in range(1, k + 1):
        selected_nums.append(i)
        find_permutations(cnt + 1)
        selected_nums.pop()

# 순열 찾기 시작
find_permutations(0)
