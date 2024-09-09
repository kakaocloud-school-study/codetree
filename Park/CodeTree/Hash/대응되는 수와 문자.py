# n개의 단어와 m개의 질문을 입력.
n, m = map(int, input().split())

# 단어 목록을 입력받아 리스트로 저장.
words = [input() for _ in range(n)]

# 각 단어에 대응되는 숫자를 기록할 딕셔너리 생성
string_to_num = {words[i]: i + 1 for i in range(n)}

# m개의 질문에 대해 처리
for _ in range(m):
    query = input()

    # 입력이 숫자인지 확인.
    if query.isdigit():
        # 숫자 입력일 경우 해당 숫자에 대응되는 단어를 출력
        print(words[int(query) - 1])
    else:
        # 문자열 입력일 경우 해당 문자열에 대응되는 숫자를 출력
        print(string_to_num[query])
