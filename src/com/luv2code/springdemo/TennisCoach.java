package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("fileFortuneService") // default, same name as the class, first letter lowercased
	FortuneService fortuneService;
	
	// the same under the hood as spring-demo-one, but this time we use autowired for 
	// dependency injection, constructor injection via autowired
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) { 
//		this.fortuneService = theFortuneService;
//	}
	public TennisCoach() {
		System.out.println("Inside default no-arg constructor for TennisCoach");
	}
//	
//	@Autowired
//	public void nameDoesntMatter(FortuneService theFortuneService) { 
//		System.out.println("Inside nameDoesntMatter() due to Spring's @autowired setter dependency injection");
//		fortuneService = theFortuneService;
//	}
	/*
	 * @autowired constructor and setter dependency injection are essentially the same thing.
	 * Just grab a class defined to be a @Component, create an instance, and pass him along
	 * 
	 * Lol, looks like you can pass a @Component instance to any method defined by @Autowired.
	 * DUPED!
	 * */
	
	// define init and destroy methods 
	
	@PreDestroy
	public void cleanupStuff() { 
		System.out.println("do my cleanupStuff()");
	}
	
	@Override
	public String getDailyWorkout() { 
		return "Practice your backhand volley";
	}

	@Override 
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
