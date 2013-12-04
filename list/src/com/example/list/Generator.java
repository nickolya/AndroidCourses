package com.example.list;

import java.util.ArrayList;
import java.util.Random;

public class Generator {
	
	public static String[] firstNames = {"John", "Jeff", "Bill", "Jordan", "Nick"};
	public static String[] lastNames = {"Smith", "Bond", "Gates", "Trump", "Gogol"};
	
	public static ArrayList<Student> generate(){
		ArrayList<Student> students = new ArrayList<Student>();
		
		Random rand = new Random();
		
		for (int i = 0; i<100; i++){
			Student student = new Student(firstNames[rand.nextInt(5)], lastNames[rand.nextInt(5)], 1913 + rand.nextInt(100));
			students.add(student);
		}
		
		return students;
	}
	

}
