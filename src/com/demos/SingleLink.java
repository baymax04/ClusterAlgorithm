package com.demos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleLink {

//	List<Person> data=new ArrayList<Person>();
	private List<Person> data;
	public SingleLink(List<Person> list) {  //���캯����ʼ����
		// TODO Auto-generated constructor stub
		data=list;
	}
	
	//��������֮��ľ���
	public List<Set<Person>> compute(){
		List<Set<Person>> list =new ArrayList<Set<Person>>();

		//�������
		double[][] ds=new double[data.size()][data.size()];
		
		for(int i=0;i<data.size();i++){
			Person p1=data.get(i);//row
			for(int j=i+1;j<data.size();j++){
				Person p2=data.get(j);//ÿ�еĵ�j����
				//��������֮��ľ���
				ds[i][j]=getDistance(p1,p2);
				//�Գƾ���
				ds[j][i]=ds[i][j];
			}
			ds[i][i]=0.0;//�������Ϊ0
		}
		
		//�����������ֵ
		System.out.println("========�������=======");
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
				continue;//���ڵ㱻ʹ�ù�����������ѭ��
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

	//��������֮��ľ��뺯��
	private double getDistance(Person p1, Person p2) {
		double distance=Math.pow(p1.getAge()-p1.getAge(),2 )+
				        Math.pow(p1.getIncome()-p1.getIncome(),2 );
		return Math.sqrt(distance);
	}
	
	
	
}
