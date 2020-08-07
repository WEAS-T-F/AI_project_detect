package aipd.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aipd.frame.Biz;
import aipd.frame.Dao;
import aipd.vo.DetectVO;

@Service("detectbiz")
public class DetectBiz implements Biz<String, DetectVO> {

	@Resource(name = "detectdao")
	Dao<String, DetectVO> dao;

	@Override
	public DetectVO get(String menuID) {
		return dao.select(menuID);
	}

	@Override
	public ArrayList<DetectVO> get() {
		return dao.selectall();
	}

	@Override
	public void register(DetectVO model) {
		// TODO Auto-generated method stub
		
	}

}