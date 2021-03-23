# 깊이 우선 탐색, 수를 정해주면 순열 구하기

n, m = map(int, input().split())

visited = [False] * (n)
ans = []


def dfs(depth, idx, N=n, M=m):
    if depth == M:
        print(' '.join(map(str, ans)))
        return

    for i in range(idx, N):
        if not visited[i]:
            visited[i] = True
            ans.append(i + 1)
            dfs(depth + 1, i + 1)
            visited[i] = False
            ans.pop()


dfs(0, 0)


# # 내부 함수로 해결하기
# from itertools import permutations
#
# N, M = map(int, input().split())
# P = permutations(range(1, N + 1), M)
# for i in P:
#     print(' '.join(map(str, i)))  # tuple -> str



