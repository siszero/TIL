import glob
import cv2
import pandas as pd
import openpyxl
from openpyxl.utils.dataframe import dataframe_to_rows
from skimage.metrics import structural_similarity as ssim
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

# 열 너비 자동 맞춤
def AutoFitColumnSize(worksheet, columns=None, margin=2):
    for i, column_cells in enumerate(worksheet.columns):
        is_ok = False
        if columns == None:
            is_ok = True
        elif isinstance(columns, list) and i in columns:
            is_ok = True

        if is_ok:
            length = max(len(str(cell.value)) for cell in column_cells)
            worksheet.column_dimensions[column_cells[0].column_letter].width = length + margin

def image_compare():
    # 통합 문서 객체 생성
    wb = openpyxl.Workbook()
    # 시트 선택
    ws = wb.active
    ws.append(['index', 'Similarity', 'different image'])
    refLst = []
    SearchExtFiles(sys.argv[1],'.bmp',refLst)   # main 있는 자리에 이미지가 있으면 경로 지정할 때 ./ 으로 놓기  (경로는 edit_Configuration 에서 parameter 바꾸기)
    compLst = []
    SearchExtFiles(sys.argv[2],'.bmp', compLst)

    # 파일 전체 읽기 위해 glob 함수 사용
    ref_img_list = refLst
    compare_img_list = compLst

    for i in range(len(ref_img_list)):

        imageA = cv2.imread(ref_img_list[i])
        imageB = cv2.imread(compare_img_list[i])
        imageC = imageA.copy()
        if (ref_img_list[i] == compare_img_list[i]):
            tempDiff = cv2.subtract(imageA, imageB)

        grayA = cv2.cvtColor(imageA, cv2.COLOR_BGR2GRAY)
        grayB = cv2.cvtColor(imageB, cv2.COLOR_BGR2GRAY)

        (score, diff) = ssim(grayA, grayB, full=True)
        diff = (diff * 255).astype("uint8")
        print(f"Similarity: {score:.5f}")
        if (score == 1):
            print("같음")
        # 다를 땐 엑셀로 이미지 파일 이름 뽑기
        else:
            diff_image = ref_img_list[i]
            print(diff_image)
            df = pd.DataFrame([[score, diff_image]], index=[ws.max_row/2+0.5], columns=['Similarity', 'different image'])
            # df = pd.DataFrame([[score, diff_image]])
            # 시트에 데이터프레임 삽입
            for r in dataframe_to_rows(df, index=True, header=False):  # True 면 변경 가능 False면 변경 불가능
                ws.append(r)
            print("다름")

        # assert 함수는 디버깅 모드에서 개발자가 오류가 생기면 치명적일 것이라는 곳에 심어 놓는 에러 검출용 코드
        assert score, "다른 점 찾을 수 없음"

    df = df.reset_index(inplace=True)

    AutoFitColumnSize(ws)
    # df.index=df.index+1
    # 엑셀 파일에 저장
    wb.save("./test.xlsx")

    # 아무 키나 눌러서 종료하기
    cv2.waitKey(0)


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    image_compare()
