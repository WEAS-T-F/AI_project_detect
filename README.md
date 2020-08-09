# AI College 팀 프로젝트

> 번호판 인식 기술과 Line Detecion 기술을 활용한 불법주차 탐지 프로젝트

* 프로젝트 기간 : 2020.08.03~8.28
* 팀원 : 5명
* 팀명 : AIPD (AI _ Illegal Parking Detection)

---



* 2020.08.05 license_plate_detection 추가 ( 3자리 번호판 생성 )
  * augmentation , perspective 3자리 번호판 추가 필요
  * 기존 image generator code에서 max test 길이 및 Y_data 수정하였음
  * make_image.ipynb 참고하여 데이터생성 할 것
  * trainig_test.ipynb 이용하여 학습 가능 
  
    

* 2020.08.06 진행상황 
  * augmetation 학습데이터 생성코드 수정 중
  * 3자리 번호판 및 2자리 번호판에 맞는 코드 작성 필요, 연구중



* 2020.08.07 진행상황

  * 2자리 번호판 및 3자리 번호판 혼합 인식 학습 모델 (정확도 60%) 구현 , 학습 데이터 9000장 (Loss 값 3.xx)

  * ![이미지 174](https://user-images.githubusercontent.com/58680436/89638461-d2447180-d8e6-11ea-8b92-c935615e33f8.png)
  
  1. 학습용 데이터 자체 마지막에 "X"를 붙여서 만들고 학습시키는 방안 시도 예정
    2. 학습용 데이터 및 Augmentation 수량 늘려서 재시도 예정
  
    * Prediction 시 한글 변환 및 지역 표지 인지에 있어서 낮은 정확성을 보이고 있음.
  
  * 이미지 19만장 데이터 학습 결과 loss값이 0.1정도 되는 weight로 prediction을 진행하였음
  
    * 2자리 번호판이 모두 aaaaaa로 예측
    * 3자리 번호판은 대부분 정확하게 맞춤
  
    ![이미지 175](https://user-images.githubusercontent.com/58680436/89638462-d3759e80-d8e6-11ea-8f77-946bdf6b4d4f.png)
    ![이미지 176](https://user-images.githubusercontent.com/58680436/89638465-d3759e80-d8e6-11ea-98bc-1e4939af7337.png)
  
    -> 문제점? : 학습에 사용하는 데이터에 3자리 번호판의 개수가 일반 번호판에 비해 4배가량 많아 발생한 현상으로 추측,
  
    새로운 데이터셋으로 학습 예정 ( Type1~Type5 각 만장 Type6~Type9 각 2천장 ) + Augmentation 같은 비율
  
  * 서버 백엔드 및 단위 테스트 확인 중 (Spring xml파일 인식 안되는 문제 발생)
  
* 2020.08.09 진행상황

  * 이미지 비율을 맞춰서 학습시켜보았으나
  * ![이미지 178](https://user-images.githubusercontent.com/58680436/89727864-79e6ae80-da63-11ea-9431-0494287e7203.png)
  * ![이미지 180](G:\화면캡쳐\이미지 180.png)
    * 같은 결과가 도출되었음. -> 다른 방법 구상필요

---

* 환경

  * OS : Windows 10
  * GPU : RTX 2070
  * CUDA : 10.0
  * cuDNN : 7.4.1
  * tensorflow-gpu : 1.14 // numpy < 1.6
  * keras : 2.1.3
  
  
  
* Refer 하고 있는 github 주소

  https://github.com/qjadud1994/CRNN-Keras

