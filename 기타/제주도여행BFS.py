# 철호는 고내라는 마을에서 구경했던 7개의 각 장소가
# 출발지 1에서 각 지점의 거리를 알아보려고 합니다.
# 가까운 순서대로 출력하는 프로그램을 작성하세요.
# (인접한 두 지점 사이의 거리는 모두 같습니다.)

graph = {
    1: [2, 3, 4],
    2: [5],
    3: [5],
    4: [],
    5: [6, 7],
    6: [],
    7: [3],
}


def dfs(s):
    discovered = [s]
    queue = [s]
    while queue:
        v = queue.pop(0)
        for w in graph[v]:
            if w not in discovered:
                discovered.append(w)
                queue.append(w)
    return discovered


a = dfs(1)
print(a)
