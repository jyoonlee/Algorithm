# 스택으로 수열 만들기
import sys

input = sys.stdin.readline

n = int(input())
li = []
stack = []
result = []
value = []

for _ in range(n):
    li.append(int(input()))

i = 0
j = 1
flag = 1

while len(result) != n:
    if i == n:
        flag = 0
        print("NO")
        break

    while li[i] not in stack and len(stack) < n + 1:
        stack.append(j)
        j += 1
        value.append("+")

    if li[i] in stack:
        result.append(stack.pop())
        value.append("-")

    i += 1

if flag == 1:
    print("\n".join(x for x in value))



import sys

input = sys.stdin.readline

# n = int(input())
#
# count = 0
# stack = []
# result = []
# no_message = True
#
# for i in range(0, n):
#     x = int(input())
#
#     while count < x:
#         count += 1
#         stack.append(count)
#         result.append('+')
#
#     if stack[-1] == x:
#         stack.pop()
#         result.append('-')
#     else:
#         no_message = False
#         continue
# if no_message == False:
#     print('NO')
# else:
#     print("\n".join(result))