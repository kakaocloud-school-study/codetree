import sys


def sol(n):
    for five_count in range(n // 5, -1, -1):
        if (n - (five_count * 5)) % 2 == 0:
            two_count = (n - (five_count * 5)) // 2
            print(five_count + two_count)
            return
    print(-1)


n = int(sys.stdin.readline())
sol(n)
