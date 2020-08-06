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

    1. 학습용 데이터 자체 마지막에 "X"를 붙여서 만들고 학습시키는 방안 시도 예정
    2. 학습용 데이터 및 Augmentation 수량 늘려서 재시도 예정

    * Prediction 시 한글 변환 및 지역 표지 인지에 있어서 낮은 정확성을 보이고 있음.

---

* 환경

  * OS : Windows 10
  * GPU : RTX 2070
  * CUDA : 10.0
  * cuDNN : 7.4.1
  * tensorflow-gpu : 1.14
  * keras : 2.1.3
  
  
  
* Refer 하고 있는 github 주소

  https://github.com/qjadud1994/CRNN-Keras

