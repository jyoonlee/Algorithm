# 체스판 칠하기 문제
# 이대로 내면 컴파일 오류라고 뜸, 왜지?

N, M = map(int, input().split())

inp = []
ans = []

for _ in range(N):
    inp.append(input())

for i in range(N-7):
    for j in range(M-7):
        result1 = 0
        result2 = 0
        for a in range(i, i+8):
            for b in range(j, i+8):
                if (b + a) % 2 == 0:
                    if inp[a][b] != 'W':
                        result1 += 1
                    if inp[a][b] != 'B':
                        result2 += 1
                else:
                    if inp[a][b] != 'B':
                        result1 += 1
                    if inp[a][b] != 'W':
                        result2 += 1

        ans.append(result1)
        ans.append(result2)

print(min(ans))


# 참고 답안
#
# n, m = map(int, input().split())
# l = []
# mini = []
#
# for _ in range(n):
#     l.append(input())
#
# for a in range(n - 7):
#     for i in range(m - 7):
#         idx1 = 0
#         idx2 = 0
#         for b in range(a, a + 8):
#             for j in range(i, i + 8):              # 8X8 범위를 B와 W로 번갈아가면서 검사
#                 if (j + b)%2 == 0:
#                     if l[b][j] != 'W': idx1 += 1
#                     if l[b][j] != 'B': idx2 += 1
#                 else :
#                     if l[b][j] != 'B': idx1 += 1
#                     if l[b][j] != 'W': idx2 += 1
#         mini.append(idx1)                          # W로 시작했을 때 칠해야 할 부분
#         mini.append(idx2)                          # B로 시작했을 때 칠해야 할 부분
#
# print(min(mini))                                   # 칠해야 하는 개수의 최소값


