n, m = map(int, input().split())

count = 0

while True:
    if n % m == 0:
        n /= m
        count += 1

    else:
        n -= 1
        count += 1

    if n == 1:
        break

print(count)

# 정답 코드
#
# n, k = map(int, input().split())
# result = 0
#
# while n >= k:
#     while n % k != 0:
#         n -= 1
#         result += 1
#     n //= k
#     result += 1
#
# while n > 1:
#     n -= 1
#     result += 1
#
# print(result)
