package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudyJavaConfigDemoApp {

	public static void main(String[] args) {

		System.out.println("Creating a context defined in Java Config. This is where we get all our beans.");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		System.out.println("Grab the bean instantiated from the context.");
		StudyCoach myCoach = context.getBean("studyCoach", StudyCoach.class);
		
		System.out.println("Verify that the new bean, coach, and fortune service wire up properly");
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune());
		
	}

}
