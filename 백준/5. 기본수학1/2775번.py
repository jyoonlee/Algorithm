# https://www.acmicpc.net/problem/2775
# 행렬에서 합 이용해서 값 유도하는 문제 

T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())

    person = [i for i in range(1, n+1)]
    new_person = [0 for _ in range(n)]

    for _ in range(k):
        for j in range(len(person)):
            new_person[j] = sum(person[:j + 1])
        person = new_person.copy()

    print(new_person[n-1])
