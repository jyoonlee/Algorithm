# 행렬에서 지그재그로 했을 때 위치 찾기

n = int(input())
m = 1

while m * (m + 1) / 2 < n:
    m += 1

result = n - (m - 1) * m / 2

if m % 2 == 1:
    print("{}/{}".format(int(m + 1 - result), int(result)))
else:
    print("{}/{}".format(int(result), int(m + 1 - result)))
