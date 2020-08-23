# -*- coding: cp949 -*-
# -*- coding: utf-8 -*- # 한글 주석쓰려면 이거 해야함
import numpy as np
import cv2
def convert_color(img):
    image = cv2.cvtColor(img,cv2.COLOR_BGR2HLS)
    return image
def yellow_mask(image):
    lower = np.uint8([15, 60, 60])
    upper = np.uint8([50, 255, 255])
    yellow_mask = cv2.inRange(image, lower, upper)
    return yellow_mask
# yellow_filter
def yellow_filter(img):
    # BGR to HSV
    hsv = cv2.cvtColor(img,cv2.COLOR_BGR2HSV)
    # Yellow 범위 지정
    yellow1 = np.array([15,70,70])
    yellow2 = np.array([60,255,255])
    # Yellow 마스크 생성
    yellow_mask = cv2.inRange(hsv,yellow1,yellow2)
    yellow_filter = cv2.bitwise_and(img,img,mask=yellow_mask)
    return yellow_filter
# Gray_Scale
def grayscale(img):
    return cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
# Gaussian_Blur
def gaussian_blur(img,kernel_size):
    return cv2.GaussianBlur(img,(kernel_size,kernel_size),0)
# Edge
def canny(img,low_thr,high_thr):
    return cv2.Canny(img,low_thr,high_thr)
# Region of Interest
def region_of_interest(img,vertices):
    mask = np.zeros_like(img)
    if len(img.shape) > 2:
        channel_count = img.shape[2]
        ignore_mask_color = (255,)*channel_count
    else:
        ignore_mask_color = 255
    cv2.fillPoly(mask, vertices, ignore_mask_color)
    ROI_img = cv2.bitwise_and(img,mask)
    return ROI_img
'''
# 오른쪽 사다리꼴
vertices_right_square = np.array([[(w/2,h),(w/2,0),
                                    (w,h/2),(w,h)]],dtype=np.int32)
# 중앙 삼각형
            vertices_triangle = np.array([[(0,h),(w/2,h/2),
                                    (w,h)]],dtype=np.int32)
# 오른쪽 아래 직사각형
vertices_right_down_rectangle = np.array([[(w/2,h),(w/2,h/2),
                                (w,h/2),(w,h)]],dtype=np.int32)
# 수직 기울기 제한
line_arr = line_arr[np.abs(slope_degree)>95]
slope_degree = slope_degree[np.abs(slope_degree)>95]
'''
def draw_lines(img,lines,color=[0,255,255],thickness=5):
    try:
        for line in lines:
            for x1,y1,x2,y2 in line:
                cv2.line(img,(x1,y1),(x2,y2),color,thickness)
    except:
        pass
def hough_lines(img):
    rho = 1
    theta = np.pi/180
    threshold = 150
    min_line_len = 100
    max_line_gap = 100
    lines = cv2.HoughLinesP(img,rho,theta,threshold, np.array([]),
                           minLineLength=min_line_len,
                           maxLineGap=max_line_gap)
    #line_img = np.zeros((img.shape[0],img.shape[1],3),dtype=np.uint8)
    #draw_lines(line_img, lines)
    return lines
def weighted_img(img, initial_img, alpha=0.8, beta=1.,gamma=0.):
    return cv2.addWeighted(initial_img,alpha,img,beta,gamma)
video_file = "./Videos/test1.mp4"
# 동영상 캡처 객체 생성
cap = cv2.VideoCapture(video_file)
if cap.isOpened():
    fps = cap.get(cv2.CAP_PROP_FPS) # 동영상 프레임 수 저장
    delay = int(1000/fps) # delay 값 저장
    print("FPS: %f, Delay: %dms" %(fps, delay))
    while True:
        ret, img = cap.read() # 다음 프레임 읽기
        if ret: # 프레임 읽기 정상
            image = convert_color(img)
            yellow_img = yellow_filter(image)
            gray_img = grayscale(yellow_img)
            blur_img = gaussian_blur(gray_img,5)
            edges_img = canny(blur_img,50,150)
            # ROI Mask 만들기
            w = img.shape[1]
            h = img.shape[0]
            # 위 절반
            upper = np.array([[(0,h),(w,h),(w,h/2),(0,h/2)]],dtype=np.int32)
            mask = region_of_interest(edges_img, upper)
            lines = hough_lines(edges_img)
            line_arr = np.squeeze(lines, 1)
            try:
                arr_len = len(line_arr)
                #print(line_arr)
            except:
                arr_len = 0
            try:
                # 기울기 구하기
                slope_degree = (np.arctan2(line_arr[:,1] - line_arr[:,3], line_arr[:,0] - line_arr[:,2])) * 180 / np.pi
                print(slope_degree)
                # 수평 기울기 제한
                line_arr = line_arr[np.abs(slope_degree)<170]
                slope_degree = slope_degree[np.abs(slope_degree)<170]
                # 필터링된 직선 버리기
                L_lines, R_lines = line_arr[(slope_degree>0),:], line_arr[(slope_degree<0),:]
                temp = np.zeros((image.shape[0], image.shape[1], 3), dtype=np.uint8)
                L_lines, R_lines = L_lines[:,None], R_lines[:,None]
                #print(R_lines)
                # 직선 그리기
                draw_lines(temp, L_lines)
                draw_lines(temp, R_lines)
                #draw_lines(temp, lines)
            except:
                pass
            try:
                lines_edges = weighted_img(temp, img, alpha=0.8, beta=1.,gamma=0.)
            except:
                lines_edges = img
            cv2.imshow(video_file, lines_edges) # 화면에 표시
            cv2.waitKey(delay) # delay
        else:
            break # 다음 프레임 읽을 수 없음 = 재생 완료
        if cv2.waitKey(43) == ord('q'):
            break
else:
    print("can't open video.")
cap.release()
cv2.destroyAllWindows()