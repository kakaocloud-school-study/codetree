import sys


def sol(n, origin, dest):
    flip_groups = 0
    prev_flip = False
    for i in range(n):
        if not prev_flip and origin[i] != dest[i]:
            prev_flip = True
            flip_groups += 1
        if origin[i] == dest[i]:
            prev_flip = False
    print(flip_groups)


n = int(sys.stdin.readline())
origin = sys.stdin.readline().strip()
dest = sys.stdin.readline().strip()
sol(n, origin, dest)
