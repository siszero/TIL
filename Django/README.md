1.	파이썬 설치 확인


2.	설치 후 


3.	Pip 는 내부 또는 외부 명령 실행할 수 있는 프로그램 또는 배치파일이 아닙니다.    
오류 시 [제어판]-[시스템 및 보안]-[시스템]-[고급 시스템 설정]-[고급]-[환경변수]   
사용자 변수에서 path 찾아 새로 만들기 후 pip.py 위치 넣어주기   
확인 : cmd 다시 켜서 pip 치면 설치 완료   


4.	 가상환경 생성

```
 pip3 install virtualenvwrapper-win
 mkvirtualenv 가상환경이름
```


※ 가상환경 명령어
- 가상환경 활성화 : workon 가상환경이름
- 가상환경 목록 확인 : workon
- 가상환경 비활성화 : deactivate
- 가상환경 제거 : rmvirtualenv 가상환경이름


5.	Django 설치

```
pip3 install django
```


6.	Django 설치 확인

```
py -3 -m django --version  # 만약 ‘No module named django’ 에러 시
# py -m django --version 입력
```


7.	장고 사용 할 폴더 생성

```
mkdir 폴더명  # 폴더 생성
cd 폴더명 # 폴더로 이동
```


8.	프로젝트 생성

```
django-admin startproject 원하는사이트이름  # 장고 사이트 생성
cd 사이트명
```


9.	웹 서버 실행

```
python manage.py runserver
```
