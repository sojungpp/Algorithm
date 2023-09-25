import sys
input = sys.stdin.readline

from queue import PriorityQueue
queue = PriorityQueue() # 우선순위 큐

N = int(input())
for i in range(N):
    a = int(input())

    if a == 0:
        if queue.empty():
            print(0)
        else:
            print(-queue.get()) # 가장 큰 값 제거하고 - 붙여서 출력하기 (넣을 때 음수로 넣었으니까)
    else:
        queue.put(-a) # 오름차순으로 제거하기 위해 음수로 넣기