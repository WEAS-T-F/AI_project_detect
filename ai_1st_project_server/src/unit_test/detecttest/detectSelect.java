package unit_test.detecttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aipd.frame.Biz;
import aipd.vo.DetectVO;


/*
 * 	SELECT * FROM CONTAINER WHERE conID=#{conID}
 */

public class detectSelect {

	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, DetectVO> biz = (Biz<String, DetectVO>) factory.getBean("detectbiz");

		DetectVO detect = new DetectVO();

		try {
			detect = biz.get("1");
			System.out.println(detect);
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
