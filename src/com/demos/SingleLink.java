package com.demos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleLink {

//	List<Person> data=new ArrayList<Person>();
	private List<Person> data;
	public SingleLink(List<Person> list) {  //构造函数初始化类
		// TODO Auto-generated constructor stub
		data=list;
	}
	
	//计算两点之间的距离
	public List<Set<Person>> compute(){
		List<Set<Person>> list =new ArrayList<Set<Person>>();

		//距离矩阵
		double[][] ds=new double[data.size()][data.size()];
		
		for(int i=0;i<data.size();i++){
			Person p1=data.get(i);//row
			for(int j=i+1;j<data.size();j++){
				Person p2=data.get(j);//每行的第j个数
				//计算两点之间的距离
				ds[i][j]=getDistance(p1,p2);
				//对称矩阵
				ds[j][i]=ds[i][j];
			}
			ds[i][i]=0.0;//自身距离为0
		}
		
		//输出距离矩阵的值
		System.out.println("========距离矩阵=======");
		for(int i=0;i<ds.length;i++){
			for(int j=0;j<ds.length;j++){
				System.out.print((int)ds[i][j]+"\t");
			}
			System.out.println();
		}
		
		boolean[] hasUsed=new boolean[ds.length];
		for(int i=0;i<ds.length;i++){
			Set<Person> setDs=new HashSet<Person>();
			if(hasUsed[i]){
				continue;//若节点被使用过，结束本次循环
			}
			for(int j=i;j<ds.length;j++){
				if(ds[i][j]<=ds.length&&hasUsed[j]==false){
					setDs.add(data.get(j));
					hasUsed[j]=true;
				}
			}
			if(setDs.size()>0){
				list.add(setDs);
			}
		}
		return list;
	}

	//计算两点之间的距离函数
	private double getDistance(Person p1, Person p2) {
		double distance=Math.pow(p1.getAge()-p1.getAge(),2 )+
				        Math.pow(p1.getIncome()-p1.getIncome(),2 );
		return Math.sqrt(distance);
	}
	
	
	
}
