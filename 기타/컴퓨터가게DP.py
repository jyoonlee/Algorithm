# 탐욕(Greedy) 알고리즘
# 동철이는 컴퓨터 수리 가게를 운영합니다.
# 1인이 운영하는 가게이며 5명의 손님이 들어왔습니다.
# 5명의 손님은 서로 다른 문제를 해결하기 위해서 왔습니다.
# 동철이는 한 번에 하나의 문제를 해결할 수 있습니다.
# 손님들이 대기하는 시간의 합이 최소로 하려면
# 어떠한 순서로 일을 해야 할 지 판단하는 프로그램을 작성하세요.
# 구체적으로 증명하세요. (동적 프로그래밍)
# 순열에 관한 문제는 동적 프로그래밍이다

jobs = [10, 8, 5, 3, 9]
jobs.sort


def simulation(njob):
    print('=== start simulation ===')
    delays = list()     # 하나의 케이스
    for i in range(0, len(njob)):
        delays.append(0)
    print(njob)

    for i in range(1, len(njob)):
        for j in range(0, i):
            delays[i] += jobs[j]
        



