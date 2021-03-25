T = int(input())


def fibo(n):
    if n == 0:
        count[0] += 1
        return 0
    elif n == 1:
        count[1] += 1
        return 1
    else:
        return fibo(n - 1) + fibo(n - 2)


for _ in range(T):
    n = int(input())
    count = [0,0]
    fibo(n)
    print("{} {}".format(count[0],count[1]))
