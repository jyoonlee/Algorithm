
N = list(map(int, str(input())))
N.sort(reverse=True)
print("".join(str(x) for x in N))