from collections import defaultdict

# 입력받기
N, M = map(int, input().split())
words = [input().strip() for _ in range(N)]

# 단어 빈도 계산
word_count = defaultdict(int)
for word in words:
    if len(word) >= M:
        word_count[word] += 1

# 단어 필터링 후 정렬
sorted_words = sorted(word_count.keys(), key=lambda x: (-word_count[x], -len(x), x))

# 결과 출력
for word in sorted_words:
    print(word)
