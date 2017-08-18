package com.dbscan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//���幤���࣬ʵ���㷨
//����������p,q֮��ľ��룬�����ؽ��
public class Utility {

	//������������
	public static double getDistance(Point p,Point q){
		int dx=p.getX()-q.getX();
		int dy=p.getY()-q.getY();
		double distance=Math.sqrt((Math.pow(dx, 2)+Math.pow(dy, 2)));
		return distance;
	}
	
	//���������ǲ��Ǻ��ĵ�
	//list  ��ŵ���б�     p:�����        e:�뾶         minp:�ܶ���ֵ       ����====��ʱ��ŷ��ʹ��ĵ�
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
		
		if(count>=minp){    //˵���Ѳ��ҵ�������
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
	 * ���b�����к���a�����а�����Ԫ�أ���ϲ������ϣ��ϲ�Ϊa����
	 */
	public static boolean mergeList(List<Point> a,List<Point> b){
		boolean merge=false;
		for(int index=0;index<b.size();++index){
			if (a.contains(b.get(index))) {  //��a�а���b��Ԫ�أ����Ǻϲ�������ֹѭ��
				merge=true;
				break;
			}
		}
		
		if(merge){    //��Ǻϲ���������
			for(int index=0;index<b.size();++index){
				if(!a.contains(b.get(index))){  //���a�в�����b��Ԫ�أ����b��Ԫ�� ��ӵ�a������
					a.add(b.get(index));
				}
			}
		}
		
		return merge;
	}
	
	/***
	 * �����ı��еĵ㼯��
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
