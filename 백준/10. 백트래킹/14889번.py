n = int(input())
li = [list(map(int, input().split())) for _ in range(n)]
check = []
result = []

def op(a, b, start):
    if len(check) == n / 2:
        for z in range(len(li)):
            if z in check:
                continue
                

        dif = sum(list(sum(x) for x in li)) - start*2
        print(dif)
        result.append(dif)

    for i in range(a, n):
        for j in range(b, n):
            if i == j:
                continue
            else:
                if i not in check and j not in check:
                    check.append(i)
                    check.append(j)
                    start += (li[i][j] + li[j][i])
                    print(i,j)
                    op(i+1, j+1, start)
                    check.pop()
                    check.pop()


op(0,0,0)
print(result)
print(min(result))
