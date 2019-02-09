package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties") // reference to where you want to source the data from 
public class SportConfig { // config java file to create/define beans manually!

	// define bean for our sad fortune service 
	@Bean 
	public FortuneService sadFortuneService() { 
		return new SadFortuneService();
	}
	
	// define bean for our life coach and inject dependency 
	@Bean 
	public Coach lifeCoach() { 
		return new LifeCoach(sadFortuneService());
	}
	
	@Bean 
	public FortuneService neutralFortuneService() { 
		return new NeutralFortuneService();
	}
	
	@Bean 
	public Coach studyCoach() { 
		return new StudyCoach(neutralFortuneService());
	}
	
}
