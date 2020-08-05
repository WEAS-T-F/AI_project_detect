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
  * gpu 환경 설정 필요 (RTX 2070, Cuda 10.0, Tensorflow 2.2 )



---

* Refer 하고 있는 github 주소

  https://github.com/qjadud1994/CRNN-Keras

