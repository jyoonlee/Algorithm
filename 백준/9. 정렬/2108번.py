# 통계를 위한 값들 구하기

def mean(v):
    return round(sum(v) / n)


def median(v):
    if n == 1:
        return v[0]
    else:
        return v[n // 2]


from collections import Counter
def fre(v):
    if n == 1:
        return v[0]
    c = Counter(v).most_common(2)
    return c[1][0] if c[0][1] == c[1][1] else c[0][0]


def ran(v):
    return v[n - 1] - v[0]


n = int(input())
v = sorted([int(input()) for _ in range(n)])

print(mean(v))
print(median(v))
print(fre(v))
print(ran(v))
