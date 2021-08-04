package main.java.enrollmentParser.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import main.java.enrollmentParser.model.User;

public class Parser {

	public static void sortCSVFile(String fileLocation) throws NumberFormatException, IOException {
		String line = "";
		Map<String, User> aetna = new HashMap<String,User>(); 
		Map<String, User> esurance = new HashMap<String,User>();
		Map<String, User> metLife = new HashMap<String,User>(); 
		Map<String, User> aflac = new HashMap<String,User>(); 
		
		BufferedReader br = new BufferedReader(new FileReader(fileLocation));
		
		while((line = br.readLine())!=null) {
			String[] userInfo = line.split(",");
			User currentUser = new User(userInfo[0],userInfo[1],userInfo[2],Integer.parseInt(userInfo[3]),userInfo[4]);
			
			switch(currentUser.getInsuranceCompany()) {
			case "Aetna":
				if(aetna.containsKey(currentUser.getUserID())) {
					if(currentUser.getVersion()> aetna.get(currentUser.getUserID()).getVersion()) {
						aetna.replace(currentUser.getUserID(), currentUser);
					}
				}else {
					aetna.put(currentUser.getUserID(), currentUser);
				}
				break;
				
			case "Esurance":
				if(esurance.containsKey(currentUser.getUserID())) {
					if(currentUser.getVersion()> esurance.get(currentUser.getUserID()).getVersion()) {
						esurance.replace(currentUser.getUserID(), currentUser);
					}
				}else {
					esurance.put(currentUser.getUserID(), currentUser);
				}
				break;
				
			case "MetLife":
				if(metLife.containsKey(currentUser.getUserID())) {
					if(currentUser.getVersion()> metLife.get(currentUser.getUserID()).getVersion()) {
						metLife.replace(currentUser.getUserID(), currentUser);
					}
				}else {
					metLife.put(currentUser.getUserID(), currentUser);
				}
				break;
				
			case "Aflac":
				if(aflac.containsKey(currentUser.getUserID())) {
					if(currentUser.getVersion()> aflac.get(currentUser.getUserID()).getVersion()) {
						aflac.replace(currentUser.getUserID(), currentUser);
					}
				}else {
					aflac.put(currentUser.getUserID(), currentUser);
				}
				break;
			}
		}
		
		List<User> aetnaAL = new ArrayList<User>(aetna.values());
		List<User> esuranceAL = new ArrayList<User>(esurance.values());
		List<User> metLifeAL = new ArrayList<User>(metLife.values());
		List<User> aflacAL = new ArrayList<User>(aflac.values());
		
		Collections.sort(aetnaAL);
		Collections.sort(esuranceAL);
		Collections.sort(metLifeAL);
		Collections.sort(aflacAL);
		
		File aetnaFile = new File("resource/aetna.csv");
		aetnaFile.createNewFile();
		FileWriter aetnawriter = new FileWriter("resource/aetna.csv");
		aetnaAL.forEach(user ->{
			try {
				aetnawriter.write(user.toString() + "\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		aetnawriter.close();
		
		FileWriter esurancewriter = new FileWriter("resource/esurance.csv");
		esuranceAL.forEach(user ->{
			try {
				esurancewriter.write(user.toString() + "\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		esurancewriter.close();
		
		FileWriter metLifewriter = new FileWriter("resource/metLife.csv");
		metLifeAL.forEach(user ->{
			try {
				metLifewriter.write(user.toString() + "\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		metLifewriter.close();
		
		FileWriter aflacwriter = new FileWriter("resource/aflac.csv");
		aflacAL.forEach(user ->{
			try {
				aflacwriter.write(user.toString() + "\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		aflacwriter.close();
		br.close();
		
	}
	
}
