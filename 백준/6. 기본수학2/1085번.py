# 점 주어지면 경계선까지 최단거리

x, y, w, h = map(int, input().split())


print(min(w-x, x, h-y, y))