import sys
input = sys.stdin.readline

M, N = map(int, input().split())

def isPrime(i):
    if i < 2:
        return False
    for j in range(2, int(i**0.5) + 1):
        if i % j == 0:
            return False
    return True

for i in range(M, N + 1):
    if isPrime(i):
        print(i, end="\n")