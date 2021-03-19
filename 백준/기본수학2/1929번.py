# 소수는 제곱근 이하의 어떠한 소수로 나눠도 나누어 떨어지지 않는다.
# 시간 복잡도 줄이기

import math

m, n = map(int, input().split())

for i in range(m, n + 1):
    flag = 0
    if i == 1:
        flag += 1
        continue

    x = int(math.sqrt(i))
    for j in range(2, x + 1):
        if i % j == 0:
            flag += 1
            break

    if flag == 0:
        print(i)
