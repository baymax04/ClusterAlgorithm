package org.cluster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleLink {

	private List<City> data;
	//默认阈值
//	private double distanceX=8;
	
	public SingleLink(List<City> list) {
		// TODO Auto-generated constructor stub
		data=list;
	}
	
	public List<Set<City>> compute(){
		List<Set<City>> list=new ArrayList<Set<City>>();
		
		//距离矩阵
		double[][] ds=new double[data.size()][data.size()];
		
		for(int i=0;i<data.size();i++){
			City city1=data.get(i);//从data链表中，获取第i个数据   ，，即第i行，横坐标
			
			for(int j=i+1;j<data.size();j++){ //每列数据，即纵坐标
				City city2=data.get(j);
				//计算两点间的距离
				ds[i][j]=getDistance(city1,city2);
				//矩阵  对称性
				
				ds[j][i]=ds[i][j];
			}
			ds[i][i]=0.0;
		}
		
		//输出距离矩阵的行列值
		for(int i=0;i<ds.length;i++){
			for(int j=0;j<ds.length;j++){
				System.out.print((int)ds[i][j]+"\t");  
			}
			System.out.println();
		}
		//该点是否被使用过   布尔矩阵
		boolean[] hasUsed=new boolean[ds.length];
		
		//遍历距离矩阵，判断布尔值
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
			//把未使用过的节点放到列表中
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
