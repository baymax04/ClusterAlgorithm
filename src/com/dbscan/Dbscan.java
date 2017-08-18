package com.dbscan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dbscan {

	private static List<Point> pointsList=new ArrayList<>();//�洢���е�ļ���
	private static List<List<Point>> resultList=new ArrayList<>();//�洢dbscan�㷨���ڵĽ����
	
	private static int e=2;//e�뾶
	private static int minp=3;//minp��ֵ
	
	/**
	 * ��ȡ�ı��е����е㲢�洢��pointsList��
	 * @param args
	 */
	
	private static void display(){
		int index=1;
		for(Iterator<List<Point>> it=resultList.iterator();it.hasNext();){
			List<Point> list=it.next();
			if(list.isEmpty()){
				continue;
			}
			
			System.out.println("========��"+index+"������==========");
			
			for(Iterator< Point> it1=list.iterator();it1.hasNext();){
				Point p=it1.next();
				System.out.println(p.print());
			}
			index++;
		}
	}
	
	//�ҳ����п���ֱ��ľ���
	private static void applyDbscan(){
		try {
			pointsList=Utility.getPointsList();//�����ı��еĵ㼯��
			
			for(Iterator< Point> it=pointsList.iterator();it.hasNext();){
				Point p=it.next();
				if(!p.isClassed()){
					List<Point> tempList=new ArrayList<>();
					if((tempList=Utility.isKeyPoint(pointsList, p, e, minp))!=null){
						//Ϊ���о�����ϵĵ�����ʶ
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
	
	//�����п���ֱ���Ǿ�����кϲ������ҳ���ӿɴ�ĵ㲢���кϲ�
	private static List<List<Point>> getResult(){
		applyDbscan();//�ҵ��������ֱ��ĵ�
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
