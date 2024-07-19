'''
i자리까지의 최소 시세로 계산한다
'''
import sys


def sol(n, fees, prices):
    min_price_at = list(prices)
    for i in range(1, n):
        min_price_at[i] = min(min_price_at[i], min_price_at[i-1])

    total = 0
    for i in range(n-1):
        total += fees[i] * min_price_at[i]

    print(total)


n = int(sys.stdin.readline())
fees = list(map(int, sys.stdin.readline().split()))
prices = list(map(int, sys.stdin.readline().split()))

sol(n, fees, prices)
