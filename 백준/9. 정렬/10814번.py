# 이름과 나이가 왔을 때 나이순으로 오름차순 같으면 먼저 가입한 순으로 출력

v = list(input().split() for _ in range(int(input())))
for i in v:
    i[0] = int(i[0])

sorted_v = sorted(v, key=lambda x: (x[0]))

for i in sorted_v:
    print(' '.join(map(str, i)))
