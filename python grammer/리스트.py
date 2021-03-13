# 0으로 채워진 리스트 생성
n = 10
a = [0] * n

# 리스트 컴프리헨션
array = [i for i in range(20) if i % 2 == 1]  # 0-19 중 홀수만 추출
array = [i * i for i in range(1, 10)]   # 1-9의 수를 제곱한 리스트 생성

