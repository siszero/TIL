# 에러 검출 방법
## Checksum
- 단순히 데이터 블럭을 내용을 바이트 또는 워드 단위로 캐리를 버리면서 전부 더한 값


## CRC (Cyclic Redundancy Check)
- 시리얼 전송에서 데이터의 신뢰성을 검증하기 위한 에러 검출 방법
- 생성 다항식(generator polynominal)이라 불리는 고정 크기의 키 값(제수, divider)으로 데이터 블럭의 값을 차례대로 나누어서 그 나머지를 누적시키는 일종의 해시 함수
- CRC 계산시의 사칙연산은 carry를 고려하지 않는다.


1. CCITT
- HKMC 에서는 16Bit 이상일 때, 이거 사용
```
체크썸 크기  : 16 비트
생성 다항식  : X^12 + X^5 + 1
제 수        : 0x1021
나머지 초기값: 0xFFFF
최종 XOR값   : 0x0000
```

2. CRC16
```
체크썸 크기  : 16 비트
생성 다항식  : X^15 + X^2 + 1
제 수        : 0x8005
나머지 초기값: 0x0000
최종 XOR값   : 0x0000
```

3. CRC32
```
체크썸 크기  : 32 비트
생성 다항식  : X^26 + X^23 + X^22 + X^16 + X^12 + X^11 +
               X^10 + X^8 + X^7 + X^5 + X^4 + X^2 + X^1 + 1
제 수        : 0x04C11DB7
나머지 초기값: 0xFFFFFFFF
최종 XOR값   : 0xFFFFFFFF
```

