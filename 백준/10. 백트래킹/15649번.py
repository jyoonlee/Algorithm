# 깊이 우선 탐색, 수를 정해주면 순열 구하기

N, M = map(int, input().split())

visited = [False] * N
result = []


def dfs(depth, N, M):
    if depth == M:
        print(' '.join(map(str, result)))
        return None
    for i in range(len(visited)):
        if not visited[i]:
            visited[i] = True
            result.append(i + 1)
            dfs(depth + 1, N, M)
            visited[i] = False
            result.pop()


dfs(0, N, M)

# # 내부 함수로 해결하기
# from itertools import permutations
#
# N, M = map(int, input().split())
# P = permutations(range(1, N + 1), M)
# for i in P:
#     print(' '.join(map(str, i)))  # tuple -> str
