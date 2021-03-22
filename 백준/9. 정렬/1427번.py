
N = list(map(int, input()))
N.sort(reverse=True)
print("".join(str(x) for x in N))