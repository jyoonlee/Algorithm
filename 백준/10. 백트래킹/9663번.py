# N-queen



n = int(input())

check = [[0] * n for _ in range(n)]
print(check[:][0])
check[:][0] = [1]*n
print(check)

count = 0


def nqueen(n, x, y):
    global count
    for i in range(x, n):
        for j in range(y,n):
            if check[i][j] == 0:
                count += 1
                check[i][:] = [1]*n
                # check[:][i] =
                print(check)
                nqueen(n, x+1, y+1)


nqueen(n, 0, 0)
# print(count, 0, 0)



