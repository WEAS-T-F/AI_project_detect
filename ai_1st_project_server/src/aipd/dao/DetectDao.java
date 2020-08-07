package aipd.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aipd.mapper.DetectMapper;
import aipd.frame.Dao;
import aipd.vo.DetectVO;

@Repository("detectdao")
public class DetectDao implements Dao<String, DetectVO> {
	@Autowired
	DetectMapper detectmapper;

	@Override
	public DetectVO select(String aipd_DTDATE) {
		return detectmapper.select(aipd_DTDATE);
	}

	@Override
	public ArrayList<DetectVO> selectall() {
		return detectmapper.selectall();
	}

	@Override
	public void insert(DetectVO model) {
		detectmapper.insert(model);
		
	}

}