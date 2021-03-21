# 터렛에서 거리로 적 위치 경우의 수 계산
# 두 원의 거리 관계 사용

T = int(input())

for _ in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    d = (((x2 - x1) ** 2 + (y2 - y1) ** 2) ** 0.5)

    if r2 > r1:
        r1, r2 = r2, r1

    if d == 0:
        if r1 == r2:
            print(-1)
        else:
            print(0)
    else:
        if (r1 + r2 == d) or (r1 - r2 == d):
            print(1)
        elif (r1 + r2) > d > (r1 - r2):
            print(2)
        else:
            print(0)
