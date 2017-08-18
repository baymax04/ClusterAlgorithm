package org.cluster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleLink {

	private List<City> data;
	//Ĭ����ֵ
//	private double distanceX=8;
	
	public SingleLink(List<City> list) {
		// TODO Auto-generated constructor stub
		data=list;
	}
	
	public List<Set<City>> compute(){
		List<Set<City>> list=new ArrayList<Set<City>>();
		
		//�������
		double[][] ds=new double[data.size()][data.size()];
		
		for(int i=0;i<data.size();i++){
			City city1=data.get(i);//��data�����У���ȡ��i������   ��������i�У�������
			
			for(int j=i+1;j<data.size();j++){ //ÿ�����ݣ���������
				City city2=data.get(j);
				//���������ľ���
				ds[i][j]=getDistance(city1,city2);
				//����  �Գ���
				
				ds[j][i]=ds[i][j];
			}
			ds[i][i]=0.0;
		}
		
		//���������������ֵ
		for(int i=0;i<ds.length;i++){
			for(int j=0;j<ds.length;j++){
				System.out.print((int)ds[i][j]+"\t");  
			}
			System.out.println();
		}
		//�õ��Ƿ�ʹ�ù�   ��������
		boolean[] hasUsed=new boolean[ds.length];
		
		//������������жϲ���ֵ
		for(int i=0;i<ds.length;i++){
			Set<City> setDs=new HashSet<City>();
			if(hasUsed[i]){
				continue;
			}
			
			for(int j=i;j<ds.length;j++){
				if(ds[i][j]<=ds.length&&hasUsed[j]==false){
					setDs.add(data.get(j));
					hasUsed[j]=true;
				}
			}
			//��δʹ�ù��Ľڵ�ŵ��б���
			if(setDs.size()>0){
				list.add(setDs);
			}
		}
		return list;
	}

	private double getDistance(City city1, City city2) {
		// TODO Auto-generated method stub
		
		double distance=Math.pow(city1.getX()-city2.getX(),2)+
				        Math.pow(city1.getY()-city2.getY(),2);
		
		return Math.sqrt(distance);
	}
}
