package com.luv2code.springdemo;

public class StudyCoach implements Coach {

	private FortuneService fortuneService;
	
	public StudyCoach(FortuneService fs) { 
		fortuneService = fs;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice unwavering focus for 14hrs/day.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
