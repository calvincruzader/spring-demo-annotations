package com.luv2code.springdemo;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component 
public class FileFortuneService implements FortuneService {

	private String fileName = "src/com.luv2code.springdemo/fortune-data.txt";
	private List<String> fortunes;
	
	public Random myRandom = new Random();
	
	// this is where you're constructing your fortunes, so of course you'd want to put it here 
	@PostConstruct 
	public void fileFortuneServiceStartup() { 
		System.out.println("Grabbing data from a given file");
		
		Path currentRelativePath = Paths.get(fileName);
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);
		File myFile = new File("src/fortune-data.txt");
		
		//read in the file data now line by line
		
		System.out.println("Reading file data from: " + myFile);
		System.out.println("File exists: " + myFile.exists());
		
		fortunes = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(myFile))) { 
			String tempLine;
			
			while((tempLine = br.readLine()) != null) { 
				fortunes.add(tempLine);
			}
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		
		int index = myRandom.nextInt(fortunes.size());
		
		return fortunes.get(index);
		
	}

}
