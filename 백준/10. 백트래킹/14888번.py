# 완전 탐색 문제
# 주어진 사칙연산 갯수와 숫자로 가능한 계산식 다 구하고 최소값 최대값 출력


N = int(input())

li = list(map(int, input().split()))
op = list(map(int, input().split()))
ans = []
met = []


def operator():
    total = li[0]
    sentence = str(li[0])
    if op.count(0) == len(op):
        for j in range(len(met)):
            if met[j] == 0:
                total += li[j + 1]
                sentence = sentence + str('+') + str(li[j + 1])
            elif met[j] == 1:
                total -= li[j + 1]
                sentence = sentence + str('-') + str(li[j + 1])
            elif met[j] == 2:
                total *= li[j + 1]
                sentence = sentence + str('*') + str(li[j + 1])
            elif met[j] == 3:
                if total < 0:
                    total = -(abs(total) // li[j + 1])
                else:
                    total //= li[j + 1]
                sentence = sentence + str('/') + str(li[j + 1])

        ans.append(total)
        return None

    for i in range(len(op)):
        if op[i] != 0:
            op[i] -= 1
            met.append(i)
            operator()
            met.pop()
            op[i] += 1


operator()
print(max(ans))
print(min(ans))
