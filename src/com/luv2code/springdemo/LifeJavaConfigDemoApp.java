package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean from Spring container
		LifeCoach theCoach = context.getBean("lifeCoach", LifeCoach.class);
		// default bean ID is className (first letter lowercased) i hate that
		
		// call method on the bean 
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		// close context 
		context.close();
		
	}

}
 