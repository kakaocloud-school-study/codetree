'''
높이차를 0~500에 대해 이진탐색
검증함수는 최소높이를 1~(500-높이차) 까지 반복하면서 최소최대 높이가 정해진 상태에서 bfs
검증함수는 500 * 100 * 100 시간 걸린다
총 log(500) * 5,000,000

이진탐색 특유의 극단적으로 큰범위가 없고(ex - 10**9)
500이라는 작은 수를 단축하는게 키포인트라서 이진탐색임을 파악하기 힘들다
'''

import sys
from collections import deque


def sol(n, m, grid):
    def in_range(r, c):
        return r >= 0 and c >= 0 and r < n and c < m

    def bfs(min_num, max_num):
        if grid[0][0] < min_num or grid[0][0] > max_num:
            return False

        drs = [1, -1, 0, 0]
        dcs = [0, 0, 1, -1]
        dq = deque([(0, 0)])
        visited = set([(0, 0)])
        while len(dq):
            r, c = dq.popleft()
            if (r, c) == (n-1, m-1):
                return True
            for dr, dc in zip(drs, dcs):
                nr, nc = r + dr, c + dc
                if not in_range(nr, nc) or (nr, nc) in visited:
                    continue
                if grid[nr][nc] < min_num or grid[nr][nc] > max_num:
                    continue
                visited.add((nr, nc))
                dq.append((nr, nc))
        return False

    def possible(diff):
        for min_num in range(1, 501 - diff):
            if bfs(min_num, min_num + diff):
                return True
        return False

    def search():
        left, right = 0, 500
        answer = -1
        while left <= right:
            mid = (left + right) // 2
            if possible(mid):
                right = mid - 1
                answer = mid
            else:
                left = mid + 1
        return answer

    print(search())


n, m = map(int, sys.stdin.readline().split())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(n, m, grid)
