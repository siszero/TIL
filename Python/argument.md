# argument

### 설명
- Edit Configuration 에서 Parameters 바꾸기
- 여러 가지 경로를 사용할 경우 : spacebar로 경로 구분
- ![예시](https://user-images.githubusercontent.com/64197543/222353406-9c077a15-0b37-4fb8-90e1-4076d7e7bd66.png)


### 코드
```python
import os
import sys

def SearchExtFiles(fpath, ext, lst):
    try:
        flist = os.listdir(fpath)
    except:
        return
    for f in flist:
        next = os.path.join(fpath, f)
        if(os.path.splitext(next)[-1] == ext):
            lst.append(next)
        if os.path.isdir(next):
            SearchExtFiles(next,ext,lst)

def main():
    refLst = []
        SearchExtFiles(sys.argv[1],'.bmp',refLst)   #argv[1] 처음으로 쓴 경로 # main 있는 자리에 이미지가 있으면 경로 지정할 때 ./ 으로 놓기  (경로는 edit_Configuration 에서 parameter 바꾸기)
    compLst = []
        SearchExtFiles(sys.argv[2],'.bmp', compLst) # argv[2] 처음 경로 후, 스페이스바로 이어진 다음 경로

```