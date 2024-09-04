# n개의 배열 요소와 목표 합 k를 입력.
n, k = map(int, input().split())
arr = list(map(int, input().split()))

# 숫자의 빈도를 저장할 딕셔너리
count = {}
ans = 0

# 배열을 순회하며 가능한 쌍의 개수를 세어준다.
for elem in arr:
    # k에서 현재 값을 뺀 값이 이미 등장했는지 확인
    ans += count.get(k - elem, 0)
    
    # 현재 숫자의 빈도를 딕셔너리에 기록하거나 업데이트
    count[elem] = count.get(elem, 0) + 1

print(ans)
