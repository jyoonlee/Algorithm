from collections import deque


def solution(progresses, speeds):
    pro = deque(progresses)
    speeds = deque(speeds)
    answer = []
    temp = []

    while progresses:
        for i in range(len(pro)):
            print(i, temp, answer)
            if pro[i] < 100:
                pro[i] += speeds[i]

            else:
                if i == 0:
                    temp.append(i)
                    print(temp)
                    answer.append(len(temp))
                    temp = []
                    pro.popleft()
                    speeds.popleft()
                else:
                    temp.append(i)
                    pro.remove(pro[i])
                    speeds.remove(speeds[i])

    return answer


progresses = [93, 30, 55]
speeds = [1, 30, 5]
print(solution(progresses, speeds))