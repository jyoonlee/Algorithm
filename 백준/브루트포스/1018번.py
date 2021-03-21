# 체스판 칠하기 문제

N, M = map(int, input().split())

inp = []
ans = []

for _ in range(N):
    inp.append(input())

for i in range(N-7):    # 8X8 인덱스는 보호해줘야 하니까
    for j in range(M-7):
        result1 = 0
        result2 = 0
        for a in range(i, i+8):
            for b in range(j, i+8):
                if (b + a) % 2 == 0:
                    if inp[a][b] != 'W': result1 += 1
                    if inp[a][b] != 'B': result1 += 1
                else:
                    if inp[a][b] != 'B': result2 += 1
                    if inp[a][b] != 'W': result2 += 1

        ans.append(result1)
        ans.appned(result2)

print(min(ans))




