import sys


def sol(n, k, coins):
    coins.reverse()

    count = 0
    for coin in coins:
        count += k // coin
        k %= coin
    print(count)


n, k = map(int, sys.stdin.readline().split())
coins = [int(sys.stdin.readline()) for _ in range(n)]

sol(n, k, coins)
