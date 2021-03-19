# 호텔에 방 배정 프로그램
# 왼쪽으로 갈 수록 가까움

n = int(input())

for _ in range(n):
    H, W, C = map(int, input().split())
    room_number = C//H + 1
    floor = C % H

    if room_number < 10:
        print(str(floor)+'0'+str(room_number))
    else:
        print(str(floor)+str(room_number))