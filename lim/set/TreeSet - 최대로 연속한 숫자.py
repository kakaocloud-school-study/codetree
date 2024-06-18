
'''
end_start_set: (끝 위치, 시작 위치)를 보관하는 집합. 숫자 삭제 시 해당 범위를 이진탐색으로 찾을 수 있다.
len_set: (길이, 시작, 끝)을 보관하는 집합. 길이가 같은 여러 범위가 들어갈 수 있으므로 시작끝을 같이 기록해 구분함
'''
import sys

from sortedcontainers import SortedSet


def sol(n, m, arr):
    len_set = SortedSet([(n+1, -1, n+1)])
    end_start_set = SortedSet([(n+1, -1)])

    def delete_num(d_num):
        # 숫자 삭제로 인해 이등분되는 범위를 제거
        pos = end_start_set.bisect_right((d_num, -1))
        d_end_start = end_start_set[pos]
        d_end, d_start = d_end_start
        d_len = (d_end - d_start - 1, d_start, d_end)
        end_start_set.remove(d_end_start)
        len_set.remove(d_len)

        # 이등분으로 만들어지는 새로운 두 범위를 삽입
        new_left = (d_num, d_start)
        nwe_right = (d_end, d_num)
        new_left_len = (d_num - d_start - 1, d_start, d_num)
        nwe_right_len = (d_end - d_num - 1, d_num, d_end)
        end_start_set.add(new_left)
        end_start_set.add(nwe_right)
        len_set.add(new_left_len)
        len_set.add(nwe_right_len)

    for d_num in arr:
        delete_num(d_num)
        longest_len, _, _ = len_set[-1]
        print(longest_len)


n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

sol(n, m, arr)
