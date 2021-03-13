n, m = map(int, input().split())
x, y, direction = map(int, input().split())

visit_map = [[0] * m for i in range(n)]
visit_map[x][y] = 1  # 현재 유저의 위치

game_map = []
for i in range(n):
    game_map.append(list(map(int, input().split())))

# 0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3


count = 1
turn_time = 0
while True:
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]

    # 방문한 적 없고, 바다가 아닌 경우
    if visit_map[nx][ny] == 0 and game_map[nx][ny] == 0:
        visit_map[nx][ny] = 1
        x = nx
        y = ny
        count += 1
        turn_time = 0
        continue
    # 방문한 적이 있거나, 바다인 경우
    else:
        turn_time +=1

    # 네 방향 모두 갈 필요가 없는 경우
    if turn_time == 4:
        nx = x - dx[direction]
        ny = y - dy[direction]

        # 뒷 방향이 바다가 아닌 경우
        if game_map[nx][ny] == 0:
            x = nx
            y = ny

        else:
            break

        turn_time = 0

print(count)
