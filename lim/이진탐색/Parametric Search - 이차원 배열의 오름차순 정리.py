'''
행렬에서 한 행을 고정시키면 각 행은 i의 배수이므로 순서를 구하는 특정수에 i를 나눠 특정수보다 작은 수 개수를 셀수있다
그외 자잘한 조건이 많다
'''

import math
import sys


def sol(n, k):
    def get_order(num):
        order = 1
        for i in range(1, n+1):
            lt_count = math.ceil(min(num, n*i+0.1) / i) - 1
            order += lt_count
        return order

    def search(target_order):
        left, right = 0, n**2
        answer = -1
        while left <= right:
            mid = (left + right) // 2
            min_order = get_order(mid)
            max_order = get_order(mid+1) - 1
            # print('order', min_order, max_order, 'left', left, 'right', right, 'mid', mid)
            if min_order <= target_order and target_order <= max_order:
                answer = mid
                break
            elif target_order < min_order:
                right = mid - 1
            else:
                left = mid + 1
        return answer

    print(search(k))


n = int(sys.stdin.readline())
k = int(sys.stdin.readline())

sol(n, k)
