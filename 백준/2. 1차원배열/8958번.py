# 주어진 OX 퀴즈 결과만큼 점수를 내는 프로그램, O가 연속되면 점수 추가

n = int(input())
for _ in range(n):
    result = list(input())

    flag = 0
    total = 0
    credit = 1

    for value in result:
        if value == 'O':
            if flag == 0:
                flag = 1
            else:
                credit += 1
            total += credit
        else:
            flag = 0
            credit = 1

    print(total)
