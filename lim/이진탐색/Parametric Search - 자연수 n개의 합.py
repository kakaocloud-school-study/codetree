import sys


def sol(s):
    def get_range_sum(num):
        return num * (num + 1) // 2

    def search(target_num):
        left, right = 0, target_num
        answer = -1
        while left <= right:
            mid = (left + right) // 2
            range_sum = get_range_sum(mid)
            if target_num >= range_sum:
                left = mid + 1
                answer = mid
            else:
                right = mid - 1
        return answer

    print(search(s))


s = int(sys.stdin.readline())

sol(s)
