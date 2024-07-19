import sys


def sol(n, line):
    c_sum = [1 if ch == 'C' else 0 for ch in line]
    w_sum = [1 if ch == 'W' else 0 for ch in line]
    for i in range(1, n):
        c_sum[i] += c_sum[i-1]
        w_sum[n-i-1] += w_sum[n-i]

    count = 0
    for i in range(1, n-1):
        if line[i] == 'O':
            count += c_sum[i] * w_sum[i]
    print(count)


n = int(sys.stdin.readline())
line = sys.stdin.readline().strip()

sol(n, line)
