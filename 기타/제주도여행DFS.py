# 철호는 제주시 애월 해안도로에 있어요.
# 해안 도로 구간에 고내라는 마을을 둘러보려고 합니다.
# 꼭 가 봐야 할 곳이 7 군데라고 하네요.
# 이동할 때 마을에서 제공하는 차를 이용할 수 있어요.
# 제공하는 차는 한 지점에서 다른 지점으로 가는 방향이 정해져 있답니다.
# 철호는 한 방향으로 갈 수 있는 곳까지 차로 이동할 거예요.
# 더 이상 갈 곳이 없으면 이전 지점까지는 걸어서 이동한답니다.
# 1을 출발 지점이라고 했을 때 모든 곳을 방문하는 순서를 예측하는 프로그램을 작성하세요.

graph = {
    1: [2, 3, 4],
    2: [5],
    3: [5],
    4: [],
    5: [6, 7],
    6: [],
    7: [3],
}


def dfs(v, discovered=[]):
    discovered.append(v)
    for w in graph[v]:
        if w not in discovered:
            discovered = dfs(w, discovered)
    return discovered


re = dfs(1)
print(re)
