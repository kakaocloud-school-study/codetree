class Pair:
    def __init__(self, x, y):
        self.x = x
        self.y = y

# 주어진 간선들
edges = [
    Pair(1, int(1e9)),
    Pair(1, 2000),
    Pair(1, 4),
    Pair(30, int(1e9)),
    Pair(6, 7),
]

# 사용되는 모든 번호를 집합(set)에 넣기
nums = set()
for edge in edges:
    nums.add(edge.x)
    nums.add(edge.y)

# 집합을 정렬하여 리스트로 변환
sorted_nums = sorted(nums)

# 각 정점별로 1번부터 순서대로 매칭하여 딕셔너리에 넣기
mapper = {num: idx + 1 for idx, num in enumerate(sorted_nums)}

# 기존 정점 번호마다 어떤 번호로 정해졌는지 출력
for num, idx in mapper.items():
    print(f"{num} -> {idx}")

# 주어진 간선을 이루는 정점 번호를 새로운 정점 번호로 변경
for i in range(len(edges)):
    edges[i] = Pair(mapper[edges[i].x], mapper[edges[i].y])

# 변경된 간선들을 출력
for edge in edges:
    print(f"({edge.x}, {edge.y})")
