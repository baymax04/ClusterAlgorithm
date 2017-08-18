package com.demos;

public class Person {

	private String name;
	private double age;//age
	private double income;//个人收入
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null){
			return false;
		}
		if(this==obj){
			return true;
		}
		
		//下转型
		Person person=(Person)obj;
		if(this.getAge()==person.getAge()&&this.getIncome()==person.getIncome()){
			return true;
		}
		return false;
	}
}
