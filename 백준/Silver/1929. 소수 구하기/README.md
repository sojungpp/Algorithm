# [Silver III] 소수 구하기 - 1929 

[문제 링크](https://www.acmicpc.net/problem/1929) 

### 성능 요약

메모리: 31256 KB, 시간: 3156 ms

### 분류

수학, 정수론, 소수 판정, 에라토스테네스의 체

### 문제 설명

<p>M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.</p>

### 출력 

 <p>한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.</p>

---

## 풀이 방법
|변수명|설명|
|:---|:---|
|M, N|M이상 N이하 조건|

1978 문제와 다른 점 (시간 초과 문제로 선택한 해결 방법)
1. 소수인 지 판별하는 함수(isPrime) 분리 → for문 전체 순환 전에 i%j==0 이면 바로 소수가 아니라고 판별
2. isPrime 내에서 2 ~ i 까지 검사하는 것이 아닌, 2 ~ i의 제곱근(i ** 0.5)까지만 검사 (어차피 대칭이니까!)
   ex. 2 * 8 = 16, 8 * 2 = 16
