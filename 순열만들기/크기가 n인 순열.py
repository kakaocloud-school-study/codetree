# 변수 선언 및 입력
n = int(input())
visited = [False] * (n + 1)
picked = []

# 순열 생성 함수
def generate_permutations(depth):
    if depth == n:  # 모든 원소를 선택했을 때
        print(" ".join(map(str, picked)))
        return

    for i in range(1, n + 1):
        if not visited[i]:  # 방문하지 않은 원소 선택
            visited[i] = True
            picked.append(i)

            generate_permutations(depth + 1)  # 다음 깊이로 이동

            visited[i] = False  # 상태 복구
            picked.pop()

generate_permutations(0)  # 깊이 0부터 시작
