package com.lily.demos;

public class Node {

	private String name;
	private double x;
	private double y;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj ==null){
			return false;
		}
		if(obj==this){
			return true;
		}
		Node node=(Node)obj;
		if(this.getX()==node.getX()&&this.getY()==node.getY()){
			return true;
		}
		return false;
	}
}
