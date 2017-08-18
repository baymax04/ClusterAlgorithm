package com.lily.demos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleLinkDemo {

	private List<Node> data;
	public SingleLinkDemo(List<Node> list) {
		// TODO Auto-generated constructor stub
		data=list;
	}
	
	//������������
	public List<Set<Node>> compute(){
		List<Set<Node>> list=new ArrayList<>();
		//�������
		double[][] ds=new double[data.size()][data.size()];
		//������������ �ڵ�֮��ľ���
		for(int i=0;i<ds.length;i++){
			Node node1=data.get(i);//��i������
			for(int j=i+1;j<ds.length;j++){
				Node node2=data.get(j);//��i�еĵ�j������
				//�������
				ds[i][j]=getDistance(node1,node2);
				//�Գƾ���
				ds[j][i]=ds[i][j];
			}
			ds[i][i]=0;//�������Ϊ0
		}
		
		//������������
		for(int i=0;i<ds.length;i++){
			for(int j=0;j<ds.length;j++){
				System.out.print((int)ds[i][j]+"\t");
			}
			System.out.println();
		}
		
		boolean[] hasUsed=new boolean[ds.length];
		
		for(int i=0;i<ds.length;i++){
			Set<Node> setDs=new HashSet<>();
			
			if(hasUsed[i]){
				continue;//���ڵ��ѱ�ʹ�ã�������ѭ����������һ��ѭ��
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

	private double getDistance(Node node1, Node node2) {
		// TODO Auto-generated method stub
		double distance=Math.pow(node1.getX()-node2.getX(), 2)+
						Math.pow(node1.getY()-node2.getY(), 2);
		return (int)Math.sqrt(distance);
	}
}
