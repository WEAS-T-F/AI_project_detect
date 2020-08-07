package aipd.mapper;

import java.util.ArrayList;

import aipd.vo.UserVO;

/*
 * USER 테이블은 
 * ID로 select, update는 아이디를 제외한 패스워드와 Type 가능
 * 
 */

public interface UserMapper {

	public UserVO select(String userID);

	public ArrayList<UserVO> selectall();

	public void insert(UserVO model);
	
	public void delete(String userID);
	
	public void update(UserVO model);
	

}