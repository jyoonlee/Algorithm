# n보다 크고 2n보다 같거나 작은 소수 개수 구하기
import math

while True:
    n = int(input())

    result = [x for x in range(n+1, 2 * n + 1)]
    if 1 in result:
        result.remove(1)

    for i in range(2, int(math.sqrt(2 * n + 1))):
        for j in result:
            if j % i == 0 and j != i:
                result.remove(j)

    print(len(result))

    if n == 0:
        break


# 에낭그레체인가 뭔가 그거 다시써서 해보자