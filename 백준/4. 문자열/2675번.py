n = int(input())

for _ in range(n):
    m = list(map(str, input().split()))
    array = list(m[1])

    for i in array:
        print(i * int(m[0]), end="")
    print("")

# n = int(input())
#
# for i in range(n):
#     a, b = input().split()
#     for j in b:
#         print(j * int(a), end='')
#     print()
