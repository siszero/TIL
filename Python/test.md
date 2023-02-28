# 이미지 비교

### 코드
```python
import pandas as pd
import openpyxl
from openpyxl.utils.dataframe import dataframe_to_rows
import glob
import os
import cv2
from skimage.metrics import structural_similarity as ssim
#from skimage.measure import compare_ssim

# # Reference test case
# imageA = cv2.imread("C:/Users/uif31275/Desktop/telltale1.png")

# # Compare test case
# imageB = cv2.imread("C:/Users/uif31275/Desktop/telltale2.png")
# imageC = imageA.copy()
# df.to_excel('C:/Users/uif31275/Desktop/export_sample.xlsx', sheet_name='result')

# 통합 문서 객체 생성
wb = openpyxl.Workbook()
# 시트 선택
ws = wb.active


# 파일 전체 읽기 위해 glob 함수 사용
ref_img_list = glob.glob("C:/Users/uif31275/Desktop/ref/*.bmp") # *.bmp 확장자 파일만 읽음
compare_img_list = glob.glob("C:/Users/uif31275/Desktop/compare/*.bmp") # *.bmp확장자 파일만 읽음

for i in range(len(ref_img_list)):
    imageA = cv2.imread(ref_img_list[i])
    imageB = cv2.imread(compare_img_list[i])
    
    if(ref_img_list[i] == compare_img_list[i]):
        tempDiff = cv2.subtract(imageA, imageB)

    grayA = cv2.cvtColor(imageA, cv2.COLOR_BGR2GRAY)
    grayB = cv2.cvtColor(imageB, cv2.COLOR_BGR2GRAY)
    # cv2.imshow("grayA", grayA)

    (score, diff) = ssim(grayA, grayB, full=True)
    diff = (diff * 255).astype("uint8")
    print(f"Similarity: {score:.5f}")
    if(score == 1):
        print("같음")
    # 다를 땐 엑셀로 이미지 파일 이름 뽑기
    else:
        diff_image = ref_img_list[i]
        df = pd.DataFrame([score, diff_image], index=[i], columns=['Similarity', 'different image'])
        # 시트에 데이터프레임 삽입
        for r in dataframe_to_rows(df, index=True, header=False): # True 면 변경 가능 False면 변경 불가능
            ws.append(r)
        print("다름")

    # assert 함수는 디버깅 모드에서 개발자가 오류가 생기면 치명적일 것이라는 곳에 심어 놓는 에러 검출용 코드
    assert score, "다른 점 찾을 수 없음"


    thresh = cv2.threshold(diff, 0, 255, cv2.THRESH_BINARY_INV | cv2.THRESH_OTSU)[1]

    # 차이점 빨간색으로 칠하기
    tempDiff[thresh == 255] = [0, 0, 255]
    imageC[thresh == 255] = [0, 0, 255]

    # 다른 점 diff3.png로 저장
    cv2.imwrite("C:/Users/uif31275/Desktop/diff.png", imageC)

# 결과 출력
# cv2.imshow("Original", imageA)
# cv2.imshow("Compare", imageB)
# cv2.imshow("Difference", imageC)
# cv2.imshow("Gray", diff)
# cv2.imshow("Gray2", tempDiff)

# 엑셀 파일에 저장
wb.save("C:/Users/uif31275/Desktop/test.xlsx")

# 아무 키나 눌러서 종료하기
cv2.waitKey(0)
```
[이미지 처리](https://btw-e-m.tistory.com/3)
[이미지 유사도](https://velog.io/@tmvkrorl/%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%9C%A0%EC%82%AC%EB%8F%84-%EB%B6%84%EC%84%9D)
[파일저장](https://ponyozzang.tistory.com/619)