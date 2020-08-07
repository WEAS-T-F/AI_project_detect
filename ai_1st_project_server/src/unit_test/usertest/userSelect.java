package unit_test.usertest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aipd.frame.Biz;
import aipd.vo.UserVO;


/*
 * 	SELECT * FROM CONTAINER WHERE conID=#{conID}
 */

public class userSelect {

	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, UserVO> biz = (Biz<String, UserVO>) factory.getBean("userbiz");

		UserVO user = new UserVO();

		try {
			user = biz.get("USER01");
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
