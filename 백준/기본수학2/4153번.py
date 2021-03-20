# 직각 삼각형인지 판단하기

while True:
    li = list(map(int, input().split()))
    li.sort()

    if li.count(0) == 3:
        break

    if li[2] == (li[0]**2 + li[1]**2)**0.5:
        print("right")
    else:
        print("wrong")



