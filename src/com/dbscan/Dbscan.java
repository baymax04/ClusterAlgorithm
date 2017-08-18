package com.dbscan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dbscan {

	private static List<Point> pointsList=new ArrayList<>();//存储所有点的集合
	private static List<List<Point>> resultList=new ArrayList<>();//存储dbscan算法反悔的结果集
	
	private static int e=2;//e半径
	private static int minp=3;//minp阈值
	
	/**
	 * 提取文本中的所有点并存储在pointsList中
	 * @param args
	 */
	
	private static void display(){
		int index=1;
		for(Iterator<List<Point>> it=resultList.iterator();it.hasNext();){
			List<Point> list=it.next();
			if(list.isEmpty()){
				continue;
			}
			
			System.out.println("========第"+index+"个聚类==========");
			
			for(Iterator< Point> it1=list.iterator();it1.hasNext();){
				Point p=it1.next();
				System.out.println(p.print());
			}
			index++;
		}
	}
	
	//找出所有可以直达的聚类
	private static void applyDbscan(){
		try {
			pointsList=Utility.getPointsList();//返回文本中的点集合
			
			for(Iterator< Point> it=pointsList.iterator();it.hasNext();){
				Point p=it.next();
				if(!p.isClassed()){
					List<Point> tempList=new ArrayList<>();
					if((tempList=Utility.isKeyPoint(pointsList, p, e, minp))!=null){
						//为所有聚类完毕的点做标识
						Utility.setListClassed(tempList);
						resultList.add(tempList);
					}
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//对所有可以直达是聚类进行合并，即找出间接可达的点并进行合并
	private static List<List<Point>> getResult(){
		applyDbscan();//找到所余可以直达的点
		int length=resultList.size();
		for(int i=0;i<length;++i){
			for(int j=i+1;j<length;++j){
				if(Utility.mergeList(resultList.get(i), resultList.get(j))){
					resultList.get(j).clear();
				}
			}
		}
		
		return resultList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stubS

		getResult();
		display();
	}

}
