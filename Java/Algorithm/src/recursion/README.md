# 재귀함수(Recursive Fuction)
자기 자신을 다시 호출하는 함수
재귀 함수의 종료 조건을 반드시 명시해야 한다.
- 컴퓨터가 함수를 연속적으로 호출하면 컴퓨터 메모리 내부의 스택 프레임에 쌓인다. 그래서 스택을 사용해야 할 때, 구현상 스택 라이브러리 대신에 재귀 함수를 이용하는 경우가 많다.

Ex)
- 팩토리얼
- 최대공약수(유클리드 호제법)
    - 두 자연수 A,B에 대하여 (A>B) A를 B로 나눈 나머지를 R이라고 하자
    - 이 때, A와 B의 최대공약수는 B와 R의 최대공약수와 같다.

    ```python
    def gcd(a,b):
        if a%b==0:
            return b
        else:
            return gcd(b, a%b)
    print(gcd(192, 162)
    ```
    실행 결과
    6

