# 나정도면 평균은 넘겠지 문제

n = int(input())

for _ in range(n):
    student = list(map(int, input().split()))
    avg = (sum(student) - student[0]) / student[0]

    count = 0
    for i in range(1, len(student)):
        if student[i] > avg:
            count += 1

    result = count / student[0]*100
    print("%.3f%%" % result)

