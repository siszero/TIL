# [NULL 처리하기](https://programmers.co.kr/learn/courses/30/lessons/59410)

## 중요 개념
- NULL 값만 다른 값으로 처리하고 싶을 때 : IFNULL(컬럼명, "바꾸고 싶은 내용")


## MYSQL
```
SELECT ANIMAL_TYPE, IFNULL(NAME, "No name") AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
```