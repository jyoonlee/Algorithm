# 입력 받은 숫자를 자리수끼리 더하기

n = int(input())
m = list(input())

total = 0
for i in m:
    total += int(i)

print(total)