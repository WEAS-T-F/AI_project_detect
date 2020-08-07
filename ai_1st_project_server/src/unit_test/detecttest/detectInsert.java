package unit_test.detecttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aipd.frame.Biz;
import aipd.vo.DetectVO;

public class detectInsert {

	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, DetectVO> biz = (Biz<String, DetectVO>) factory.getBean("detectbiz");

		DetectVO detect = new DetectVO();
		detect.setAipd_DTNUM("test1");
		detect.setAipd_DTDATE("2020-08-04-16:33");
		detect.setAipd_DTPLATENUM("123사5678");
		detect.setAipd_DTIMAGE("123tk5678.jpg");

		
		System.out.println(detect.toString());


		try {
			biz.register(detect);
			System.out.println("detect Register Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
