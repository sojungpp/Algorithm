import sys
input = sys.stdin.readline

result = 0
numOfDivisor = int(input())
standard = numOfDivisor//2
divisor = list(map(int, input().split()))

if standard == 0:
	print(divisor[0]*divisor[0])
else:
	print(min(divisor) * max(divisor))