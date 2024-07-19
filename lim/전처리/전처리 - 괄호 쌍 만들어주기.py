import sys


def sol(line):
    double_left_counts = [0] * len(line)

    def is_double_left(idx):
        if idx < 1 or line[idx] != '(':
            return False
        return line[idx] == line[idx-1]

    def is_double_right(idx):
        if idx + 1 > len(line) - 1 or line[idx] != ')':
            return False
        return line[idx] == line[idx+1]

    total = 0
    for i, ch in enumerate(line):
        if is_double_left(i):
            double_left_counts[i] += 1
        double_left_counts[i] += double_left_counts[i-1]
        if is_double_right(i):
            total += double_left_counts[i]
    print(total)


line = sys.stdin.readline().strip()

sol(line)
