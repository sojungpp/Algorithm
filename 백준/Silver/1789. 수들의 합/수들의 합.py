import sys
input = sys.stdin.readline

# 서로 다른 N개의 자연수의 합
S = int(input())
sum = 0

# 0부터 합이 S가 될 때까지 작은 수부터 더해가기
for i in range(1, S+1):
    sum += i
    # 합과 동일하다면 i 출력
    if sum == S:
        print(i)
        break
    # 합보다 크다면 i-1 출력
    elif sum > S:
        print(i-1)
        break