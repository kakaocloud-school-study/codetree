'''
시작끝을 분리한 정점 정보를 리스트화해서 정렬한다
하나씩 조회하는데 조회한 점이 시작점이면 y좌표 힙에 넣고 끝점이면 삭제된 색으로 기록해놨다가 힙조회 전에 0에 올경우 삭제한다
각 순간마다 보이는 색정보를 힙을 통해 알 수 있으므로 set에 넣어놨다가 사이즈를 출력한다
'''

import heapq
import sys


def sol(n, sticks):
    colors = [None] * (len(sticks) * 2)
    points = []
    for color, stick in enumerate(sticks):
        y, x1, x2 = stick
        points.append((x1, y, True, color))
        points.append((x2, y, False, color))
    points.sort()

    y_heap = []
    removed_colors = set()
    for i in range(len(colors)):
        x, y, start, color = points[i]
        if start:
            heapq.heappush(y_heap, (y, x, color))
        else:
            removed_colors.add(color)

        while len(y_heap) > 0 and y_heap[0][2] in removed_colors:
            heapq.heappop(y_heap)

        if len(y_heap):
            _, _, bottom_color = y_heap[0]
        else:
            bottom_color = None
        colors[i] = bottom_color

    colors = set(colors)
    if None in colors:
        colors.remove(None)
    print(len(colors))


n = int(sys.stdin.readline())
sticks = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(n, sticks)
