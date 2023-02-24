# swprintf()
- 와이드 문자 형식화 및 버퍼에 기록
- 함수를 사용해 버퍼에 여러 값을 형식화 및 버퍼에 저장

### Format
- %c : wchar_t 에 문자 인수 변환
- %lc 및 %C : wchar_t 를 wchar_t 에 복사
- %s : 멀티바이트 문자 배열을 wchar_t 배열로 변환
- %ls 및 %S : wchar_t 의 배열 복사



### 리턴 값
- swprintf() 함수는 오류가 발생했을 때, 음수 값 또는 종료 널 와이드 문자를 계산하지 않고 출력 버퍼에 기록된 와이드 문자 개수 리턴
- n 개 이상의 와이드 문자를 기록하도록 요청되면 음수 값이 리턴

### 예시
```C
#include <stdio.h>
#include <wchar.h>

int main() {
	const wchar_t* textdata = L"RPM CON";
	wchar_t buff[100] = { 0, };

	(void)swprintf(buff, 100, L": %ls", textdata);
	printf("%ls", buff);

	return 0;
}

--> 결과 값은 : RPM CON
```