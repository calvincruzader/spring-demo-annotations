package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

	@Value("${fillerValue.email}")
	private String email;

	@Value("${fillerValue.team}")
	private String team;
	
	public String getEmail() { 
		return email;
	}
	
	public String getTeam() {
		return team;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
