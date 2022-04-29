# [DATETIME에서 DATE로 형 변환](https://programmers.co.kr/learn/courses/30/lessons/59414)

## 중요 개념
- DATETIME에서 DATE로 형변환 : DATE_FORMAT
- 년-월-일로 작성 :  '%Y-%m-%d


## MYSQL
```
# DATE형변환 시  '%Y-%m-%d'  쓸 경우
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS 날짜
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
```
<img width="557" alt="" src="https://user-images.githubusercontent.com/64197543/165902493-13d60799-7641-46bf-936f-f8ebfbdeca3b.PNG">


```
# DATE형변환 시  '%Y-%M-%D'  쓸 경우
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%M-%D') AS 날짜
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
```

<img width="563" alt="" src="https://user-images.githubusercontent.com/64197543/165902488-268297e3-1658-4203-beb2-0a17ca90dd91.PNG">