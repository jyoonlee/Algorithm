# 상수는 숫자를 거꾸로 읽는 버릇이 있음

a, b = map(str, input().split())

if int(a[::-1]) > int(b[::-1]):
    print(a[::-1])
else:
    print(b[::-1])

# print("".join(reversed(a)))