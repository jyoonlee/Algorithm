# https://www.acmicpc.net/problem/2839
# 설탕공장 문제, 그리디 같아보이지만 아님

N = int(input())
# 3 or 5
count = 0
while True:
    if N % 5 == 0:
        count += N//5
        break
    else:
        N -= 3
        count += 1
        if N < 0:
            count = -1
            break

print(count)
