# 변수 선언 및 입력
n, m = tuple(map(int, input().split()))
numbers = [int(input()) for _ in range(n)]

# 폭발이 발생했는지 여부를 확인하는 변수
did_explode = True

# 폭발이 발생하지 않을 때까지 반복
while did_explode:
    did_explode = False
    idx = 0

    # 리스트를 순회하며 연속된 숫자를 체크
    while idx < len(numbers):
        count = 1
        while idx + count < len(numbers) and numbers[idx + count] == numbers[idx]:
            count += 1
        
        # 연속된 숫자의 수가 m 이상인 경우
        if count >= m:
            did_explode = True
            del numbers[idx:idx + count]  # 해당 범위를 리스트에서 제거
        else:
            idx += count

# 남아있는 숫자의 개수와 숫자들 출력
print(len(numbers))
for number in numbers:
    print(number)
