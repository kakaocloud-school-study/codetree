# 변수 선언 및 입력:
n = int(input())  # 문자열의 개수를 입력받음
words = [input() for _ in range(n)]  # n개의 문자열을 리스트로 입력받음

# 문자열의 빈도를 저장할 딕셔너리와 최대 빈도수 초기화
frequency_map = {}
max_frequency = 0

# 각 문자열의 빈도를 딕셔너리에 기록
for word in words:
    # 문자열이 딕셔너리에 없으면 초기값으로 1을 설정
    if word not in frequency_map:
        frequency_map[word] = 1
    # 이미 존재하면 값을 1 증가
    else:
        frequency_map[word] += 1

    # 최대 빈도수를 업데이트
    if frequency_map[word] > max_frequency:
        max_frequency = frequency_map[word]

print(max_frequency)
