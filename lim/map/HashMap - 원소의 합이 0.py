from collections import defaultdict
import sys


def sol(n, arrs):
    count_by_num1 = defaultdict(int)
    count_by_num2 = defaultdict(int)

    for i in range(n):
        for j in range(n):
            value_sum = arrs[0][i] + arrs[1][j]
            count_by_num1[value_sum] += 1

    for i in range(n):
        for j in range(n):
            value_sum = arrs[2][i] + arrs[3][j]
            count_by_num2[value_sum] += 1

    total = 0
    for num1 in list(count_by_num1.keys()):
        count1 = count_by_num1[num1]
        num2 = -num1
        count2 = count_by_num2[num2]
        total += count1 * count2

    return total


n = int(sys.stdin.readline())
arrs = [list(map(int, sys.stdin.readline().split())) for _ in range(4)]
print(sol(n, arrs))
