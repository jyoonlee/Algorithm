# Greedy algorithm

n, m = map(int, input().split())
result = 0

for i in range(n):
    data = list(map(int, input().split()))  # 한 줄씩 입력받음
    min_value = min(data)   # 리스트 내 가장 작은 수
    result = max(result, min_value)  # 두개의 수 중 큰 수

print(result)
