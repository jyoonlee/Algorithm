# 괄호 찾기 문제지만 조금 심화

import sys
input = sys.stdin.readline

while True:
    s = input().rstrip()
    stack = []
    flag = 1

    for i in s:
        if i == '(' or i == '[':
            stack.append(i)
        elif i == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                flag = 0
                break
        elif i == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                flag = 0
                break

    if s == '.':
        break

    print('yes' if flag and not stack else "no")
