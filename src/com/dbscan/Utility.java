package com.dbscan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//定义工具类，实现算法
//测试两个点p,q之间的距离，并返回结果
public class Utility {

	//计算两点间距离
	public static double getDistance(Point p,Point q){
		int dx=p.getX()-q.getX();
		int dy=p.getY()-q.getY();
		double distance=Math.sqrt((Math.pow(dx, 2)+Math.pow(dy, 2)));
		return distance;
	}
	
	//检查给定点是不是核心点
	//list  存放点的列表     p:待测点        e:半径         minp:密度阈值       返回====暂时存放访问过的点
	public static List<Point> isKeyPoint(List<Point> list,Point p,int e,int minp){
		int count=0;
		List<Point> tempList=new ArrayList<>();
		for(Iterator<Point> it=list.iterator();it.hasNext();){
			Point q=it.next();
			if(getDistance(p, q)<=e){
				++count;
				if(!tempList.contains(q)){
					tempList.add(q);
				}
			}
		}
		
		if(count>=minp){    //说明已查找到新样本
			p.setKey(true);
			return tempList;
		}
		return null;
	}
	
	public static void setListClassed(List<Point> list){
		for(Iterator<Point> it=list.iterator();it.hasNext();){
			Point p=it.next();
			if(!p.isClassed()){
				p.setClassed(true);
			}
		}
	}
	
	
	
	/**
	 * 如果b集合中含有a集合中包含的元素，则合并两集合，合并为a集合
	 */
	public static boolean mergeList(List<Point> a,List<Point> b){
		boolean merge=false;
		for(int index=0;index<b.size();++index){
			if (a.contains(b.get(index))) {  //若a中包含b中元素，则标记合并，并终止循环
				merge=true;
				break;
			}
		}
		
		if(merge){    //标记合并。。。。
			for(int index=0;index<b.size();++index){
				if(!a.contains(b.get(index))){  //如果a中不含有b中元素，则把b中元素 添加到a集合中
					a.add(b.get(index));
				}
			}
		}
		
		return merge;
	}
	
	/***
	 * 返回文本中的点集合
	 */
	
	public static List<Point> getPointsList() throws IOException{
		List<Point> list=new ArrayList<>();
		String path="src\\com\\dbscan\\points.txt";
		BufferedReader br=new BufferedReader(new FileReader(path));
		
		String str="";
		while((str=br.readLine())!=null  && str!=""){
			list.add(new Point(str));
		}
		br.close();
		return list;
	}
}
