package unit_test.detecttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aipd.frame.Biz;
import aipd.vo.DetectVO;

/*
 * DELETE FROM CONTAINER WHERE CONID = #{conID}
 */
public class detectDelete {


	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, DetectVO> biz = (Biz<String, DetectVO>) factory.getBean("detectbiz");
		DetectVO detect = new DetectVO();
		detect = biz.get("1");
		System.out.println(detect);
		System.out.println(detect.getAipd_DTDATE());
		String test = detect.getAipd_DTDATE();
		try {
			biz.remove(test);
			System.out.println("detect delete Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
