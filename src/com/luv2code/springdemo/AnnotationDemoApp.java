package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring config file 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from Spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		// default bean ID is className (first letter lowercased) i hate that
		
		// call method on the bean 
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());
		
		SwimCoach coach2 = (SwimCoach) context.getBean("swimCoach");
		System.out.println(coach2.getEmail());
		System.out.println(coach2.getTeam());
		
		// close context 
		context.close();
		
	}

}
 