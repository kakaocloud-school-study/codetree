import sys
from collections import deque


def sol(n, g, groups):
    unpicked_users_by_group = [set(groups[i]) for i in range(g)]
    picked_users = set()
    group_ids_by_user = [set() for _ in range(n)]
    user_queue = deque([0])

    def pick_user(user_id):
        picked_users.add(user_id)
        for group_id in group_ids_by_user[user_id]:
            unpicked_users_by_group[group_id].remove(user_id)

    # 이중 반복문이지만 "모든 그룹 내 사람 수의 총합 ≤250,000"
    for group_id, group in enumerate(groups):
        for user_id in group:
            group_ids_by_user[user_id].add(group_id)

    pick_user(0)
    while len(user_queue):
        user_id = user_queue.popleft()
        for group_id in group_ids_by_user[user_id]:
            if len(unpicked_users_by_group[group_id]) == 1:
                unpicked = unpicked_users_by_group[group_id].pop()
                unpicked_users_by_group[group_id].add(unpicked)
                pick_user(unpicked)
                user_queue.append(unpicked)

    print(len(picked_users))


n, g = map(int, sys.stdin.readline().split())
groups = [set(list(map(lambda x: int(x)-1, sys.stdin.readline().split()))[1:])
          for _ in range(g)]

sol(n, g, groups)
