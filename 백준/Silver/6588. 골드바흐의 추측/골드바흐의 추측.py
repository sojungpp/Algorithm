import sys
input = sys.stdin.readline

MAX = 1000000
prime = [True] * (MAX + 1)
for i in range(2, MAX + 1):
    if prime[i] == True:
        for j in range(i*2, MAX + 1, i):
                prime[j] = False

while 1:
    n = int(input())
    if n == 0:
        break
    for a in range(3, len(prime), 2):
        if (prime[a] == True) and (prime[n-a] == True):
            print("%d = %d + %d" % (n, a, n-a))
            break
    else:
        print("Goldbach's conjecture is wrong.")