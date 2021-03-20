prime_number = [0 for _ in range(10001)]
prime_number[1] = 1

for i in range(2, int(10000 ** 0.5) + 1):
    for j in range(i * 2, 10001, i):
        prime_number[j] = 1

T = int(input())
for i in range(T):
    n = int(input())
    m = n // 2

    for j in range(m, 1, -1):
        if prime_number[n - j] == 0 and prime_number[j] == 0:
            print(j, n - j)
            break

# def prime_value(n):
#     prime = [True] * (n + 1)
#
#     m = int(n ** 0.5)
#     for i in range(2, m + 1):
#         if prime[i]:
#             for j in range(i + i, n + 1, i):
#                 prime[j] = False
#
#     return [x for x in range(2, n) if prime[x] == True]
#
#
# def add_value(n):
#     result = prime_value(n)
#     dif = 10001
#     a = 0
#     b = 0
#
#     for i in result:
#         if n - i in result:
#             if dif > abs(n - 2 * i):
#                 dif = abs(n - 2 * i)
#                 a = min(i, n - i)
#                 b = max(n - i, i)
#
#     print("{} {}".format(a, b))
#
#
# T = int(input())
#
# for _ in range(T):
#     n = int(input())
#     add_value(n)
