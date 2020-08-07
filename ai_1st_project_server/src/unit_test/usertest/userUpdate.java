package unit_test.usertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aipd.frame.Biz;
import aipd.vo.UserVO;

public class userUpdate {

	@Autowired
	public static void main(String[] args) {
		/*
		 * <update id = "update" parameterType="container"> UPADATE CONTAINER SET
		 * CONWARINGWEIGHT=#{conWarningWeight},CONWARNINGQUANTITY=#{conWarningQuantity},
		 * CONUNITWEIGHT=#{conUnitWeight} WHERE CONID = #{conID}
		 * 
		 */

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, UserVO> biz = (Biz<String, UserVO>) factory.getBean("userbiz");

		UserVO user = new UserVO();
		
		user.setAipd_ID("USER03");
		user.setAipd_PASSWD("USER032");
		user.setAipd_TYPE("MANAGER");
		
		System.out.println(user.toString());

		try {
			biz.modify(user);
			System.out.println("user modify Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
