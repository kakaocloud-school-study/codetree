def count_similar_pairs(words):
    def get_pattern(word):
        mapping = {}
        pattern = []
        next_char = 'a'
        for char in word:
            if char not in mapping:
                mapping[char] = next_char
                next_char = chr(ord(next_char) + 1)
            pattern.append(mapping[char])
        return ''.join(pattern)
    
    patterns = {}
    for word in words:
        pattern = get_pattern(word)
        if pattern in patterns:
            patterns[pattern] += 1
        else:
            patterns[pattern] = 1
    
    count = 0
    for value in patterns.values():
        if value > 1:
            count += value * (value - 1) // 2
    
    return count

# 입력 처리
N = int(input())
words = [input().strip() for _ in range(N)]

# 비슷한 단어 쌍의 수를 계산하여 출력
result = count_similar_pairs(words)
print(result)
