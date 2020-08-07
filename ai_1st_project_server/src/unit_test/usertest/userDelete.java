package unit_test.usertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aipd.frame.Biz;
import aipd.vo.UserVO;

/*
 * DELETE FROM CONTAINER WHERE CONID = #{conID}
 */
public class userDelete {


	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, UserVO> biz = (Biz<String, UserVO>) factory.getBean("userbiz");
		UserVO user = new UserVO();
		user = biz.get("USER01");
		System.out.println(user);
		System.out.println(user.getAipd_ID());
		String test = user.getAipd_ID();
		try {
			biz.remove(test);
			System.out.println("user delete Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
