import sys

while True:

    input = sys.stdin.readline
    n = int(input())
    if n == 0:
        break

    prime = [True] * (n+1)

    m = int(n ** 0.5)
    for i in range(2, m + 1):
        if prime[i]:
            for j in range(i*2, n+1, i):
                prime[j] = False

    print(len([i for i in range(n+1) if prime[i]])-2)

    # 다른 방법

    a = set([i for i in range(3, n + 1, 2)])
    for i in range(3, n + 1, 2):
        if i in a:
            a -= set([i for i in range(i * 2, n + 1, i)])

    print(len(a)+1)




