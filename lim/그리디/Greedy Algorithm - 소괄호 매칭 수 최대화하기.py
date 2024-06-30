import sys
from functools import cmp_to_key


def sol(n, words):
    def get_count(word):
        left_count = 0
        count = 0
        for ch in word:
            if ch == '(':
                left_count += 1
            else:
                count += left_count
        return count

    def cmp(word1, word2):
        return get_count(word2+word1) - get_count(word1+word2)

    words.sort(key=cmp_to_key(cmp))
    print(get_count(''.join(words)))


n = int(sys.stdin.readline())
words = [sys.stdin.readline().strip() for _ in range(n)]
sol(n, words)
