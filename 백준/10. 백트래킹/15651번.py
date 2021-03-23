# 깊이 우선 탐색, 수를 정해주면 순열 구하기

N, M = map(int, input().split())

visited = [False] * N
result = []


def dfs(depth, N, M):
    if depth == M:
        print(' '.join(map(str, result)))
        return None
    for i in range(len(visited)):
        # if not visited[i]:
        # visited[i] = True
        result.append(i + 1)
        dfs(depth + 1, N, M)
        # visited[i] = False
        result.pop()


dfs(0, N, M)
