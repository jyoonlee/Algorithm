a = [2143,12512,23,22,6,7,8,9,10,5,3,4,2,1]

for i in range(len(a)):
    for j in range(i+1, len(a)):
        if a[i] + a[j] == 3:
            print(a[i])
            print(a[j])