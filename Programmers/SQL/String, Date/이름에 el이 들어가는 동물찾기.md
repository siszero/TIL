# [이름에 el이 들어가는 동물 찾기](https://programmers.co.kr/learn/courses/30/lessons/59047)

## 중요 개념
- A AND B : A와 B가 모두 TRUE면 반환
- LIKE : '~와 같다', 조회 조건 값이 명확하지 않을 때 사용
- %는 '모든 문자'라는 의미고, _는 '한 글자'라는 의미

```
NAME LIKE '%원' : 이름이 원으로 끝나는 행 조회
ID LIKE '_K_' : ID의 가운데가 K이고 3글자인 행 조회
```

- MySQL에서는 대소문자를 구분하지 않음. 따라서 "%EL%', "%eL%', "%El%', "%el% 모두 같음


## MYSQL
#### 내 코드
```
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = "Dog" AND NAME LIKE "%el%"
ORDER BY NAME
```


[참고](https://jione-e.tistory.com/74?category=962393)