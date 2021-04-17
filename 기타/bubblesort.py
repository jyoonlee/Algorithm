def bubblesort1(A):
    for i in range(1, len(A)):
        for j in range(0, len(A) - 1):
            if A[j] > A[j + 1]:
                A[j], A[j + 1] = A[j + 1], A[j]


def bubblesort2(A):
    alen = len(A)
    while alen > 1:
        for j in range(0, len(A) - 1):
            if A[j] > A[j + 1]:
                A[j], A[j + 1] = A[j + 1], A[j]
        alen -= 1


a = [3, 4, 2, 7, 1, 6, 4, 5, 8, 9]
bubblesort2(a)
for i in a:
    print(i, end=' ')
