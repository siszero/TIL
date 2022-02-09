# 머신러닝
풀고자 하는 문제의 정답과 데이터를 주고 기계를 학습시켜서 정답을 맞추게 하는 것


\- 알고리즘
문제를 풀기 위한 의사 결정 과정   

\- 데이터
주관적인 기준이 아닌 수치에 근거한 객관적인 기준   
객관적인 기준을 위한 정답과 요인들   

\- 학습
수치에 들어갈 값을 컴퓨터가 스스로 찾는다!   
데이터로부터 최적의 값을 찾는 과정

![1](https://user-images.githubusercontent.com/64197543/153232211-9614d297-2055-4319-b70a-b458903b7c04.PNG)

## 머신러닝 알고리즘의 종류
1. 지도 학습
정답이 있는 문제를 풀 경우

2. 비지도 학습
정답이 없는 문제를 풀 경우


### 정답의 종류에 따른 ⭐️지도 학습⭐️
1. 회귀 (Regression)
정답이 연속형 변수일 때
    - 연속형 변수
        - 값이 정수처럼 명확하지 않고 실수 범위 내에서 계속해서 연속해서 값이 있는 경우
        - eg) 키, 몸무게
    - 회귀 분석 문제
        - 키를 이용해 몸무게 예측하기


2. 분류 (Classification)
정답이 비연속형(범주형) 변수일 때
    - 범주형 변수
        - 값이 정수처럼 명확함
            - eg) 성별, 도시
        - 분류 문제
            - 키와 몸무게를 이용해 성별 맞추기


### ⭐️비지도 학습⭐️ 의 종류
1. 군집분석 (Clustering)
주어진 데이터가 어떻게 구성되어 있는지 알아내려는 분석 방법

2. 강화학습 (Reinforcement Learning)
행동에 따른 보상을 최대화 시키는 학습 방법


# Model Selection
모델
- 어떤 X가 주어 졌을 때 f 라는 함수를 통해 y라는 값을 도출하는 과정
- 이 때의 함수 f 를 모델 또는 알고리즘이라고 부른다.

모델의 수식
y = F(X)
- X : 데이터
- y : 예측값

모델의 목적
- 데이터를 이용해 값을 예측

모델의 평가
- 모델이 값을 잘 예측하는지 평가

## 데이터의 종류
1. Train Data
- 학습에 사용되는 데이터

2. Test Data
- 학습에 사용되지 않은 데이터
- 모델이 실제로 잘 예측하는지 알기 위해서는 학습에 사용되지 않은 데이터를 이용해 평가해야 한다.


## 모델의 평가와 데이터의 관계
1. Underfitting (과소 적합)
학습 데이터를(Train data) 잘 맞추지 못하는 현상

2. Overfitting (과대 적합)
학습 데이터(Train data)는 잘 맞추지만 학습 데이터 외에는 잘 맞추지 못하는 현상
![](https://user-images.githubusercontent.com/64197543/153232221-d5a8f76f-87f1-4bcf-84a5-bb0c9677cf75.PNG)

Underfitting을 확인하는 방법
- Train data로 학습된 모델을 Train data로 평가한다.
- Train data를 잘 맞추지 못 한다면 Underfitting 상태

Overfitting을 확인하는 방법
- Train data을 잘 학습한 모델을 Test data로 평가한다.
- Train data는 잘 맞추지만 Test data를 잘 맞추지 못한다면 Overfitting 상태

### Data split
데이터를 Train data와 Test data 로 나누는 것
보통 7:3의 비율로 나눈다.

가끔 Train Data, Valid Data, Test Data 세 가지로 나누기도 한다.
![](https://user-images.githubusercontent.com/64197543/153232225-7e18a2e4-2520-483c-9c14-087d1325ef7f.PNG)


**각 데이터의 용도**
Train Data
- 학습에 사용되는 데이터

Valid Data
- 학습이 완료된 모델을 검증하기 위한 데이터
- 학습에 사용되지는 않지만 **관여**하는 데이터

Test Data
- 최종 모델의 성능을 검증하기 위한 데이터
- 학습에도 사용되지 않으며 관여하지도 않는 데이터

<문제점>    
Valid Data는 학습에 사용되지는 않지만 관여하는 데이터이다. 관여하기 때문에 너무 valid data에 맞추려고 할 수도 있다.  ->  Overfitting    
Valid 데이터에 Overfitting 될 수도 있음


### Cross Validation (교차검증)
Valid 데이터를 고정하지 않고 계속해서 변경함으로써 Overfitting 되는 것을 막기 위한 방법   

<종류>   
1. LOOCV (Leave One Out Cross Validation)   
하나의 데이터를 제외하고 모델을 학습한 후 평가
- 데이터 개수 만큼의 모델을 학습해야 한다.
- 데이터가 많을 경우 시간이 오래 걸린다. -> 그래서 나온 대안점이 K-Fold
![](https://user-images.githubusercontent.com/64197543/153232227-1a64a797-6440-416b-b815-335955f5169e.PNG)


2. K-Fold
- 데이터를 K 개로 분할한 후 한 개의 분할 데이터를 제외한 후 학습에 사용
- 제외된 데이터는 학습이 완료된 후 평가에 사용
![](https://user-images.githubusercontent.com/64197543/153232231-7bc5814b-2b34-4563-99eb-363051e5575e.PNG)


<Cross Validation 평가>
1. Cross Validation을 이용하면 방법에 따라 K개의 평가지표가 생성
![](https://user-images.githubusercontent.com/64197543/153232232-6c418b8d-419d-4e6b-a93a-f60487559221.PNG)

2. 생성된 평가 지표의 평균을 이용해 모델의 성능을 평가
![](https://user-images.githubusercontent.com/64197543/153232235-4d6c5d1d-8025-462f-a94b-ece15b9bbd5c.PNG)

3. 전체 Train 데이터를 이용해 모델 학습
![](https://user-images.githubusercontent.com/64197543/153232240-f576b2af-0f2d-4dbf-90a7-685afcc1541b.PNG)
