import sys
input = sys.stdin.readline
n = int(input())

result = 0
# 5원으로 나누어 떨어ㅈ
while True:
    if n % 5 == 0:
        # 5원으로 나누어 떨어지면 더해주기
        result += n // 5
        break
    else:
        result += 1
        # 2원씩 빼주기
        n -= 2
    # 거슬러주지 못하는 경우
    if n < 0:
        result = -1
        break

print(result)