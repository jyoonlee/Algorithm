T = int(input())

for _ in range(T):
    x, y = map(int, input().split())

    # x += 1
    # y -= 1

    move = 0
    count = 0
    while True:
        if y-x <= 2:
            break
        else:
            if x >= (x+y//2):
                if y-x % 2 == 1:
                    count *=2
                else:
                    count = (count - 1)*2 + 1
                break

        x += move
        move += 1
        count += 1

    print(count)



