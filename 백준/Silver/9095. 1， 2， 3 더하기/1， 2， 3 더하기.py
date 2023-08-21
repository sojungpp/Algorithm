import sys
input = sys.stdin.readline

def way(x):
    if x == 1:
        return 1
    elif x == 2:
        return 2
    elif x == 3:
        return 4
    else:
        return way(x - 3) + way(x - 2) + way(x - 1)

T = int(input())
for _ in range(T):
    n = int(input())
    print(way(n))