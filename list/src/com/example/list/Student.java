package com.example.list;

public class Student {
	
	public final String firstName;
	public final String lastName;
	public final int dob;
	
	private String photo;

	public Student(String firstName, String lastName, int dob){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
