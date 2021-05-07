import pandas as pd

f1 = pd.read_csv('output.csv', encoding='utf-8', header=None)
f2 = open('results.txt', 'r', encoding='utf-8')  # MOT

f1_time = f1[0].tolist()

# MOT를 다 읽고, CSI는 한 줄씩 읽기
f2_time = dict()

while f2:  # MOT
    line = f2.readline().split()
    if len(line) != 0:
        f2_time[line[0] + ' ' + line[1]] = line[2]
    else:
        break

label = []
label_2 = []
for i in f1_time:
    fre = [0, 0]
    fre2 = [0, 0]
    for j in f2_time.keys():

        if i[:10] == j[:10]:

            f1_second = i.split(' ')[1].split(':')
            f2_second = j.split(' ')[1].split(':')

            if f1_second[0] == f2_second[0] and f1_second[1] == f2_second[1]:

                if abs(float(f2_second[2]) - float(f1_second[2])) < 0.5:
                    fre[int(f2_time[j])] += 1

                if abs(float(f2_second[2]) - float(f1_second[2])) < 1:
                    fre2[int(f2_time[j])] += 1

    if max(fre2) == 0:
        label.append(-1)
        label_2.append(-1)
    else:
        label.append(fre.index(max(fre)))
        label_2.append(fre2.index(max(fre2)))

point = 0
check = 0
for i, j in zip(label, label_2):
    if i == j:
        point += 1

    if j >= 0:
        check += 1

print(point)
print(check)
