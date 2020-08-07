package unit_test.detecttest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aipd.frame.Biz;
import aipd.vo.DetectVO;

public class detectSelectAll {

	@Autowired
	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");

		Biz<String, DetectVO> biz = (Biz<String, DetectVO>) factory.getBean("detectbiz");

		ArrayList <DetectVO> detect;
		
		try {
			detect = biz.get();
			for(DetectVO i : detect) {
				System.out.println(i);
			}
			System.out.println("detect selectAll Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		factory.close();

	}

}
