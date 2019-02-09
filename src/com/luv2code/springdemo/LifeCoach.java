package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class LifeCoach implements Coach {

	@Value("${foo.email}")
	public String email;
	
	@Value("${foo.team}")
	public String team;
	
	private FortuneService fortuneService;
	
	public LifeCoach(FortuneService fs) { 
		fortuneService = fs;
	}
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		return "Meditate, write TODO lists, and execute on them.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
