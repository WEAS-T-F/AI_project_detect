package unit_test.usertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aipd.frame.Biz;
import aipd.vo.UserVO;

public class userInsert {

	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, UserVO> biz = (Biz<String, UserVO>) factory.getBean("userbiz");

		UserVO user = new UserVO();
		user.setAipd_IDNUM("3");
		user.setAipd_ID("USER03");
		user.setAipd_PASSWD("USER03");
		user.setAipd_TYPE("USER");
		
		System.out.println(user.toString());


		try {
			biz.register(user);
			System.out.println("user Register Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
