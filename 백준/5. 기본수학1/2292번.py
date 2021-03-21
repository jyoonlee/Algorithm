# 육각형 벌집에서 N이 주어졌을 때, 중심까지 최단 경로

n = int(input())

room = 1
count = 1
while room < n:
    room = room + (count * 6)
    count += 1

print(count)
