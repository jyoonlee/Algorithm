# n보다 크고 2n보다 같거나 작은 소수 개수 구하기

while True:
    n = int(input())
    if n == 0:
        break

    _n = 2*n+1

    prime = [True] * (_n)

    m = int(_n ** 0.5)

    for i in range(2, m + 1):
        if prime[i]:
            for j in range(i + i, _n, i):  # 배수 다 false로 바꾸기
                prime[j] = False

    result = [x for x in range(2, _n) if prime[x] == True]
    print(len([z for z in result if z>n]))
