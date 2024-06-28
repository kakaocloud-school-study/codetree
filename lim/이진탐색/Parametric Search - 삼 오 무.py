import sys


def sol(n):
    def get_order(num):
        return num - (num // 3) - (num // 5) + (num // 15)

    def search(target_order):
        left, right = 0, 10_000_000_000
        answer = -1
        while left <= right:
            mid = (left + right) // 2
            order = get_order(mid)
            if target_order <= order:
                right = mid - 1
                if target_order == order:
                    answer = mid
            else:
                left = mid + 1
        return answer

    print(search(n))


n = int(sys.stdin.readline())

sol(n)
