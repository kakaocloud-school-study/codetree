import sys


def sol(n, values, count_by_value):
    left, right = 0, n-1
    max_sum = 0
    while left <= right:
        left_value = values[left]
        right_value = values[right]
        min_count = min(count_by_value[left_value],
                        count_by_value[right_value])
        count_by_value[left_value] -= min_count
        if left != right:
            count_by_value[right_value] -= min_count

        if count_by_value[left_value] == 0:
            left += 1
        if count_by_value[right_value] == 0:
            right -= 1

        max_sum = max(
            max_sum, left_value + right_value)
    print(max_sum)


n = int(sys.stdin.readline())
values = set()
count_by_value = dict()
for _ in range(n):
    count, value = map(int, sys.stdin.readline().split())
    values.add(value)
    count_by_value[value] = count
values = sorted(list(values))
sol(n, values, count_by_value)
