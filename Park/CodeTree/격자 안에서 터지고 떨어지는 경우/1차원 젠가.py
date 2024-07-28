# 입력 처리
n = int(input())
blocks = [int(input()) for _ in range(n)]
s1, e1 = map(int, input().split())
s2, e2 = map(int, input().split())

# 블럭 제거 함수
def remove_blocks(blocks, start, end):
    return blocks[:start] + blocks[end+1:]

# 첫 번째 구간 제거
blocks = remove_blocks(blocks, s1-1, e1-1)
# 두 번째 구간 제거
blocks = remove_blocks(blocks, s2-1, e2-1)

# 출력
print(len(blocks))
for block in blocks:
    print(block)
