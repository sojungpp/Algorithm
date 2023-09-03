#push X: 정수 X를 큐에 넣는 연산이다.
#pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
#size: 큐에 들어있는 정수의 개수를 출력한다.
#empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
#front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
#back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
from collections import deque

import sys
input = sys.stdin.readline

q = deque()

N = int(input()) # 명령어의 수
for i in range(N):
    cmd = input().split()

    if cmd[0] == 'push':
        num = cmd[1]
        q.append(num)
        
    elif cmd[0] == 'pop':
        if len(q) == 0:
            print(-1)
        else:
            print(q.popleft())
            
    elif cmd[0] == 'size':
        print(len(q))
        
    elif cmd[0] == 'empty':
        if len(q) == 0:
            print(1)
        else:
            print(0)
            
    elif cmd[0] == 'front':
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
            
    elif cmd[0] == 'back':
        if len(q) == 0:
            print(-1)
        else:
            print(q[len(q)-1])