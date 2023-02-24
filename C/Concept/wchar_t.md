# wchar_t

### 사용 이유
- char * 형으로 문자열(UFT-8) 저장한다고 할 때, 알파벳과 한글을 혼용하면 엉뚱한 결과를 가져온다.
- char * 형으로 저장되는 형식을 Multi Byte String 이라고 한다.
- wchar_t 에 저장되는 형식을 Wide Character String 이라고 한다.


### 사용 방법
- 일반적으로 유니코드 형식으로 저장됨.
- 문자열 대입하기 위해서는 접두어 "L"을 붙여줌
```C
// 예시
wchar_t *str = L"한글";
```

### 표준 함수
- 보통 사용하는 str 대신 wcs 를 적어준다.
```C
strlen -> wcslen
strcpy -> wcscpy
```
- wchar_t 출력하기 위해서는 wprintf 혹은 fputws 함수 사용


### wchar_t 와 char 변환
- 소켓통신을 할 때, 데이터를 wchar_t로 받는 것보다 char * 로 받아서 형변환 하는게 쉬움
- 데이터 전송 할 때도 마찬가지로 호환성을 위해 char * 로 바꿔서 전송하는게 좋음
- wchar_t 를 char로 변환 : 함수 사용
- char 를 wchar_t 로 변환 : mbstowcs 함수 사용
