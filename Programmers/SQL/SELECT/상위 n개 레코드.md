# [상위 n개 레코드](https://programmers.co.kr/learn/courses/30/lessons/59405)

## 중요 개념
- 한 개만 출력할 때 등 출력 개수를 정해줘야 할 때 LIMIT을 사용한다.  


## MYSQL
``` java
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1
```