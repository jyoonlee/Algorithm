# 0으로 채워진 리스트 생성
n = 10
a = [0] * n

# 리스트 컴프리헨션
array = [i for i in range(20) if i % 2 == 1]  # 0-19 중 홀수만 추출
array = [i * i for i in range(1, 10)]  # 1-9의 수를 제곱한 리스트 생성

n = 3
m = 4
array = [[0] * n for i in range(m)]  # 2차원 배열 초기화
# array = [[0]*n for _ in range(m)]   # 변수 값 무시하고 for 문 시행
# ! 잘못된 예시 array = [[0] * m] * n ! 이런식으로 하면 동일한 객체로 인식해서 다른 행x열이 아니야

# 리스트 명령어
array.append([1])  # 리스트에 원소 삽입
array.sort()  # 리스트 오름차순 정렬
array.sort(reverse=True)  # 리스트 내림차순 정렬
array.reverse()  # 리스트 원소 순서 뒤집기
array.insert(2, ['a', 'b', 'c'])  # 특정한 인덱스 위치에 원소를 삽입, 2 위치에 3을 삽입
array.count(a)  # 리스트에서 특정한 값을 가지는 데이터 개수를 카운트
array.remove([1])  # 리스트 내에서 특정 값 제거, 여러 개일 경우 하나만 제거
