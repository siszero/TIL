# Async
## 1. asyncio
- 파이썬 3.5부터 지원
- 비동기 프로그래밍을 위한 모듈
- 비동기 : 여러 작업을 동시에 하는 행동
- asyncio를 쓰면 더 빠르게 처리되어야 함. -> await() 함수 나열하면 시간 동일하게 소요 -> await 과 같은 여러 코루틴 함수를 동시에 실행하여 원하는 동작하기 위해서는 create_task()사용해야 함
- 등록해야 하는 함수가 많은 경우에는 asyncio.gather() 사용


## 2. 코루틴
- 동시성 프로그래밍을 가능하게 함
- 별도의 스레도 없이 메인 스레드 상에서 번갈아가며 병렬처리와 유사한 동작 수행
- 프로그램이 실행 중일때 특정 시점에 코루틴으로 이동하고 그전에 진행 중이던 루틴은 정지

## 3. Thread
- 스레드는 비동기로 여러 스레드가 있으면 한 번에 동시에 실행




## 동기
```python
import time

def sync_task_1():
    print('sync_task_1 시작')
    print('sync_task_1 3초 대기')
    time.sleep(3)
    print('sync_task_1 종료')

def sync_task_2():
    print('sync_task_2 시작')
    print('sync_task_2 2초 대기')
    time.sleep(2)
    print('sync_task_2 종료')

start = time.time()
sync_task_1()
sync_task_2()
end = time.time()
print(end-start)
```
- 결과
```python
sync_task_1 시작
sync_task_1 3초 대기
sync_task_1 종료
sync_task_2 시작
sync_task_2 2초 대기
sync_task_2 종료
5.00602912902832
```

## 비동기
```python
import asyncio
import time

async def async_task_1():
    print('async_task_1 시작')
    print('sync_task_1 3초 대기')
    await asyncio.sleep(3)
    print('sync_task_1 재시작')

async def async_task_2():
    print('async_task_2 시작')
    print('sync_task_2 2초 대기')
    await asyncio.sleep(2)
    print('sync_task_2 재시작')

async def main():
    start = time.time()
    await async_task_1()
    await async_task_2()
    end = time.time()
    print(f'time taken: {end - start}')

asyncio.run(main())
```
- 결과
```python
sync_task_1 시작
sync_task_1 3초 대기
sync_task_1 재시작
async_task_2 시작
sync_task_2 2초 대기
sync_task_2 재시작
time taken: 5.004269123077393
```

## create_task() 사용
```python
import asyncio
import time

async def async_task_1():
    print('async_task_1 시작')
    print('sync_task_1 3초 대기')
    await asyncio.sleep(3)
    print('sync_task_1 재시작')

async def async_task_2():
    print('async_task_2 시작')
    print('sync_task_2 2초 대기')
    await asyncio.sleep(2)
    print('sync_task_2 재시작')

async def main():
    start = time.time()
    task1 = asyncio.create_task(async_task_1())
    task2 = asyncio.create_task(async_task_2())
    await task1
    await task2
    end = time.time()
    print(f'time taken: {end - start}')

asyncio.run(main())
```
```python
async_task_1 시작
sync_task_1 3초 대기
async_task_2 시작
sync_task_2 2초 대기
sync_task_2 재시작
sync_task_1 재시작
time taken: 3.0023632049560547
```