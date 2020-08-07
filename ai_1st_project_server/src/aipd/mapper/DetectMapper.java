package aipd.mapper;

import java.util.ArrayList;

import aipd.vo.DetectVO;


/*
 * detect table 은 날짜로 조회, update는 차량 번호만 가능, 삭제는 차량 번호로
 * */
public interface DetectMapper {

	public DetectVO select(String aipd_DTDATE);

	public ArrayList<DetectVO> selectall();
	
	public void insert(DetectVO model);
	
	public void update(DetectVO model);
	
	public void delete(String aipd_DTPLATENUM);

}