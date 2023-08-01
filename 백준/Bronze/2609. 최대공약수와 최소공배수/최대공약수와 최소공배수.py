import sys
input = sys.stdin.readline

a, b = map(int, input().split())
multiplyValue = a * b
temp = 0

# a와 b중 a를 큰 값으로 설정
if a < b:
    temp = a
    a = b
    b = temp

# 유클리드 호제법
while b != 0:
    temp = a % b
    a = b
    b = temp

gcd = a
# 최소공배수 = 두 값의 곱 / 최대공약수
lcm = multiplyValue // gcd

print(gcd)
print(lcm)