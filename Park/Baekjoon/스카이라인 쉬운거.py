n = int(input())  # 주어진 좌표의 개수
skyline = [tuple(map(int, input().split())) for _ in range(n)]

current_height = 0  # 현재 높이 초기화
building_count = 0  # 건물의 수 초기화

for i in range(n):
    x, y = skyline[i]
    if y > current_height:
        building_count += 1  # 높이가 증가할 때 건물이 추가됨
    current_height = y  # 현재 높이 갱신

print(building_count)