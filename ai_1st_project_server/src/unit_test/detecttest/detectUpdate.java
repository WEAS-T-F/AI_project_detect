package unit_test.detecttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aipd.frame.Biz;
import aipd.vo.DetectVO;

public class detectUpdate {

	@Autowired
	public static void main(String[] args) {
		/*
		 * <update id = "update" parameterType="container"> UPADATE CONTAINER SET
		 * CONWARINGWEIGHT=#{conWarningWeight},CONWARNINGQUANTITY=#{conWarningQuantity},
		 * CONUNITWEIGHT=#{conUnitWeight} WHERE CONID = #{conID}
		 * 
		 */

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, DetectVO> biz = (Biz<String, DetectVO>) factory.getBean("conbiz");

		DetectVO detect = new DetectVO();

		detect.setAipd_DTPLATENUM("12서5678");;
		detect.setAipd_DTNUM("1");
		System.out.println(detect.toString());

		try {
			biz.modify(detect);
			System.out.println("detect modify Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
