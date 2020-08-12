

# AIPD : 불법주정차 자동 탐지 서비스 개발

> 번호판 인식 기술과 Line Detecion 기술을 활용한 불법주차 탐지 프로젝트

* 프로젝트 기간 : 2020.08.03~8.28
* 팀원 : 5명
* 팀명 : AIPD (AI _ Illegal Parking Detection)

<img src="https://user-images.githubusercontent.com/58680436/89865262-5ef17700-dbe8-11ea-902d-3a75e3b5f14e.jpg" alt="Notes_200811_153445_d2a_1" style="zoom: 50%;" />

---



### 2020.08.05 license_plate_detection 추가 ( 3자리 번호판 생성 )

* augmentation , perspective 3자리 번호판 추가 필요
* 기존 image generator code에서 max test 길이 및 Y_data 수정하였음
* make_image.ipynb 참고하여 데이터생성 할 것
* trainig_test.ipynb 이용하여 학습 가능 

  

### 2020.08.06 진행상황 

* augmetation 학습데이터 생성코드 수정 중
* 3자리 번호판 및 2자리 번호판에 맞는 코드 작성 필요, 연구중



### 2020.08.07 진행상황

* 2자리 번호판 및 3자리 번호판 혼합 인식 학습 모델 (정확도 60%) 구현 , 학습 데이터 9000장 (Loss 값 3.xx)

  <img src="https://user-images.githubusercontent.com/58680436/89638461-d2447180-d8e6-11ea-8b92-c935615e33f8.png" alt="이미지 174" style="zoom:67%;" />


1. 학습용 데이터 자체 마지막에 "X"를 붙여서 만들고 학습시키는 방안 시도 예정
  2. 학습용 데이터 및 Augmentation 수량 늘려서 재시도 예정

  * Prediction 시 한글 변환 및 지역 표지 인지에 있어서 낮은 정확성을 보이고 있음.

* 이미지 19만장 데이터 학습 결과 loss값이 0.1정도 되는 weight로 prediction을 진행하였음

  * 2자리 번호판이 모두 aaaaaa로 예측
  * 3자리 번호판은 대부분 정확하게 맞춤

  <img src="https://user-images.githubusercontent.com/58680436/89638462-d3759e80-d8e6-11ea-8f77-946bdf6b4d4f.png" alt="이미지 175" style="zoom:67%;" />
  <img src="https://user-images.githubusercontent.com/58680436/89638465-d3759e80-d8e6-11ea-98bc-1e4939af7337.png" alt="이미지 176" style="zoom:67%;" />

  -> 문제점? : 학습에 사용하는 데이터에 3자리 번호판의 개수가 일반 번호판에 비해 4배가량 많아 발생한 현상으로 추측,

  새로운 데이터셋으로 학습 예정 ( Type1~Type5 각 만장 Type6~Type9 각 2천장 ) + Augmentation 같은 비율

* 서버 백엔드 및 단위 테스트 확인 중 (Spring xml파일 인식 안되는 문제 발생)

### 2020.08.09 진행상황

* 이미지 비율을 맞춰서 학습시켜보았으나

  <img src="https://user-images.githubusercontent.com/58680436/89727864-79e6ae80-da63-11ea-9431-0494287e7203.png" alt="이미지 178" style="zoom:67%;" />

  * 같은 결과가 도출되었음. -> 다른 방법 구상필요
  
    

### 2020.08.10 진행상황 

* 데이터 생성 시, 총 9자리 텍스트로 생성되는 타입들에 대하여 마지막에"X" 를 직접 삽입하여 파일을 생성.
* 지역번호 없을 경우 Z가 들어가는 것과 같이 일단 학습시킨 후 prediction에서 처리 해보려고 함.

* 08.10 결과 ( 이미지 72485 : 13250  비율로 50epoch 학습, 정확도 88% ) 

  <img src="https://user-images.githubusercontent.com/58680436/89747931-ead9a500-dafb-11ea-906a-e83d7535682e.png" alt="이미지 181" style="zoom:67%;" />
  <img src="https://user-images.githubusercontent.com/58680436/89747933-ec0ad200-dafb-11ea-8b37-75ed33ea6705.png" alt="이미지 182" style="zoom:67%;" />
  <img src="https://user-images.githubusercontent.com/58680436/89747934-eca36880-dafb-11ea-91d2-244cbe7b3956.png" alt="이미지 183" style="zoom:67%;" />



* epoch 와 이미지 수 늘려서 학습 , 99%의 정확도 달성

  <img src="https://user-images.githubusercontent.com/58680436/89861884-bb04cd00-dbe1-11ea-8e42-5f2d9ea01f37.png" alt="KakaoTalk_20200810_213715214" style="zoom:67%;" />

### 2020.08.11 진행상황

* 만들어진 Test data에 대해서는 잘 인식하지만, 실제 자동차 사진을 넣었을때는 인식하지 못한다.
  * 추후 진행방향
    
    0. 모델 버전 2.0으로 최적화 시킬것. -> 완료
    1. Faster-RCNN 또는 YOLO를 이용하여 Object Detection 구현, 자동차 번호판 위치 찾기
       *  샘플코드 업로드
          ( ai_1st_project\Faster_RCNN_for_Open_Images_Dataset_Keras-master\Object_detection_datapreprocessing_customby_ydh.ipynb 참고)
    2. 찾아낸 번호판을 이진화하여 만들어둔 모델에 학습시킨다.

### 2020.08.12 진행상황

* Faster RCNN을 이용한 Object detection 사용방법

  * Data Prerprocessing 에서 원하는 데이터의 label 데이터와 train 데이터, test 데이터를 받을 수 있다. 
  * Data preprocessing 과정을 거친 후 train 과 test를 실행하여 학습을 진행한다.

  

----

### 개발환경 

* OS : Windows 10

* GPU : RTX 2070

* CUDA : 10.0

* cuDNN : 7.4.1

* tensorflow-gpu : 1.14 // numpy < 1.6 

  * tensorflow 2.0.0 사용시 keras 앞에 `tensorflow.` 추가하면 모델 작동

    ```python
    from tensorflow.keras import backend as K
    from tensorflow.keras.layers import Conv2D, MaxPooling2D
    from tensorflow.keras.layers import Input, Dense, Activation
    from tensorflow.keras.layers import Reshape, Lambda, 
    from tensorflow.keras.layers import add, concatenate
    from tensorflow.keras.models import Model
    from tensorflow.keras.layers import LSTM
    ```

* keras : 2.1.3

---



* Refer 하고 있는 github 주소

  https://github.com/qjadud1994/CRNN-Keras
  
  https://github.com/RockyXu66/Faster_RCNN_for_Open_Images_Dataset_Keras

