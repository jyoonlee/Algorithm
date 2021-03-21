# 달팽이는 올라가고 싶다

A, B, V = map(int, input().split())

V = V - B

if V // (A-B) < V / (A-B):
    print((V // (A - B)) + 1)
else:
    print(V // (A-B))