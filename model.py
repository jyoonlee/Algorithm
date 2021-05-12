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
for i in f1_time:
    fre = [0, 0]
    flag = 0
    for j in f2_time.keys():
        if i[:10] == j[:10]:

            f1_second = i.split(' ')[1].split(':')
            f2_second = j.split(' ')[1].split(':')

            if int(f1_second[0]) == int(f2_second[0]) and int(f1_second[1]) == int(f2_second[1]):

                if abs(float(f2_second[2]) - float(f1_second[2])) < 0.5:
                    flag = 1
                    fre[int(f2_time[j])] += 1
                elif flag == 1:
                    break

    if max(fre) == 0:
        label.append(-1)
    else:
        label.append(fre.index(max(fre)))

print(label)



