package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
public class TennisCoach implements Coach {
	
	@Autowired
	FortuneService fortuneService;
	
	// the same under the hood as spring-demo-one, but this time we use autowired for 
	// dependency injection, constructor injection via autowired
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) { 
//		this.fortuneService = theFortuneService;
//	}
//	
	@Autowired
	public void nameDoesntMatter(FortuneService theFortuneService) { 
		System.out.println("Inside nameDoesntMatter() due to Spring's @autowired setter dependency injection");
		fortuneService = theFortuneService;
	}
	/*
	 * @autowired constructor and setter dependency injection are essentially the same thing.
	 * Just grab a class defined to be a @Component, create an instance, and pass him along
	 * 
	 * Lol, looks like you can pass a @Component instance to any method defined by @Autowired.
	 * DUPED!
	 * */
	
	@Override
	public String getDailyWorkout() { 
		return "Practice your backhand volley";
	}

	@Override 
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
