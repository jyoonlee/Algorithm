# 주어진 시험 점수에서 최고값을 골라 평균을 조작

n = int(input())
mark = list(map(int, input().split()))
m = max(mark)

for i in range(len(mark)):
    mark[i] = mark[i] / m * 100

print(round(sum(mark) / len(mark), 2))
