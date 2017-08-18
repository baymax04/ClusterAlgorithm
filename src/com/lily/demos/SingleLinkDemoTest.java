package com.lily.demos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SingleLinkDemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Node> nodes=new ArrayList<>();
		Node node0=new Node();
		node0.setName("С��");
		node0.setX(100);
		node0.setY(3);
		nodes.add(node0);
		
		Node node1=new Node();
		node1.setName("С��");
		node1.setX(7);
		node1.setY(10);
		nodes.add(node1);
		
		Node node2=new Node();
		node2.setName("С��");
		node2.setX(5);
		node2.setY(5);
		nodes.add(node2);
		
		Node node3=new Node();
		node3.setName("С��");
		node3.setX(3);
		node3.setY(10);
		nodes.add(node3);
		
		Node node4=new Node();
		node4.setName("СǷ");
		node4.setX(3);
		node4.setY(20);
		nodes.add(node4);
		
		Node node5=new Node();
		node5.setName("С��");
		node5.setX(4);
		node5.setY(9);
		nodes.add(node5);
		
		Node node6=new Node();
		node6.setName("С��");
		node6.setX(5);
		node6.setY(10);
		nodes.add(node6);
		
		long start=System.currentTimeMillis();
		
		//�㷨��ʼ
		SingleLinkDemo singleLinkDemo=new SingleLinkDemo(nodes);
		List<Set<Node>> lSets=singleLinkDemo.compute();
		
		for(Set<Node> set:lSets){
			System.out.println("***********");
			for(Node node:set){
				System.out.println(node.getName()+"\t"+node.getX()+"\t"+node.getY());
			}
		}
		
	}

}
