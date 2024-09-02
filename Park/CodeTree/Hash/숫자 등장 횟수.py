# 변수 선언 및 입력:
n, m = map(int, input().split())  # n과 m을 각각 정수로 변환하여 입력받음
arr = list(map(int, input().split()))  # n개의 정수를 리스트로 입력받음

# 숫자의 빈도를 저장할 딕셔너리 생성
frequency_map = {}

# 각 숫자의 빈도를 딕셔너리에 기록
for number in arr:
    # 숫자가 딕셔너리에 없으면 초기값으로 1을 설정
    if number not in frequency_map:
        frequency_map[number] = 1
    # 이미 존재하면 값을 1 증가
    else:
        frequency_map[number] += 1

# m개의 질의에 대한 빈도수 출력
queries = list(map(int, input().split()))  # m개의 질의를 리스트로 입력받음
for query in queries:
    # 질의된 숫자가 딕셔너리에 없으면 0을 출력
    print(frequency_map.get(query, 0), end=" ")  # get 메소드를 사용하여 기본값 0 출력
