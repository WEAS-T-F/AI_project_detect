package unit_test.usertest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aipd.frame.Biz;
import aipd.vo.UserVO;

public class userSelectAll {

	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, UserVO> biz = (Biz<String, UserVO>) factory.getBean("userbiz");

		ArrayList <UserVO> user;
		
		try {
			user = biz.get();
			for(UserVO i : user) {
				System.out.println(i);
			}
			System.out.println("user selectAll Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
