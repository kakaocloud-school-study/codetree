'''
시작점과 예상 도착 지점을 시각화하면 (start_at + speed * t)
------------      <-- 1
---------------   <-- 2
   ------         <-- 3
     -------------
       --------------
3번 선수 기준으로 시작점이 자신보다 앞에 놓였으면서 예상도착지점이 자신보다 더 뒤에 있는 1, 2번은 자신을 추월하게된다
위 법칙을 고려하여 실제 이동을 시각화하면
---------         <-- 1
---------         <-- 2
   ------         <-- 3
     -------------
       --------------

시작점 기준으로 정렬된 선수 기록 목록에 대해 한 선수씩 추가해 가며 위의 처리를 진행하면 풀이가 가능하다
'''

import sys

from sortedcontainers import SortedSet


def sol(n, t, players):
    end_set = SortedSet()

    def add_player(start_at, speed):
        end_at = start_at + speed * t
        # 추가하는 선수의 예상 도착 지점보다 더 먼 원소들을 모두 삭제
        overtaking_pos = end_set.bisect_left(end_at)
        while overtaking_pos != len(end_set):
            end_set.remove(end_set[overtaking_pos])
            overtaking_pos = end_set.bisect_left(end_at)
        end_set.add(end_at)

    for start_at, speed in players:
        add_player(start_at, speed)
    print(len(end_set))


n, t = map(int, sys.stdin.readline().split())
players = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

sol(n, t, players)
