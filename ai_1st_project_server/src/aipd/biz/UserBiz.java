package aipd.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aipd.frame.Biz;
import aipd.frame.Dao;
import aipd.vo.UserVO;

@Service("userbiz")
public class UserBiz implements Biz<String, UserVO> {

	@Resource(name = "userdao")
	Dao<String, UserVO> dao;
	
	@Override
	public UserVO get(String userID) {
		return dao.select(userID);
	}

	@Override
	public ArrayList<UserVO> get() {
		return dao.selectall();
	}
	
	@Override
	public void register(UserVO model){
		dao.insert(model);
		
	}

	@Override
	public void remove(String id) {
		
	}

	@Override
	public void modify(UserVO model) {
		
	}

	


	
	
	


}