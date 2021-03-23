# N-queen
# 해답법 : 행마다 하나의 퀸이 존재해야한다
# 대각선이거나 같은 열이면 안된다.
# 다시 풀어보기 

n = int(input())

col = [0 for i in range(14)]
ret = 0


# k번째 행에 있는 퀸이 같은 열에 있는 지 검사: col(i) = col(k)
# k번째 행에 있는 퀸이 같은 대각선에 있는 지 검사: |col(i)-col(k)| = i-k

def promising(i):
    for k in range(i):
        if col[i] == col[k] or abs(col[i] - col[k]) == i - k:
            return False
    return True


def queens(i):
    global ret

    if i == n:
        ret += 1
    else:
        for j in range(n):
            col[i] = j
            if promising(i):
                queens(i+1)


queens(0)
print(ret)
