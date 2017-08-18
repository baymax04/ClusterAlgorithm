package com.lily.demos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SingleLinkDemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Node> nodes=new ArrayList<>();
		Node node0=new Node();
		node0.setName("小明");
		node0.setX(100);
		node0.setY(3);
		nodes.add(node0);
		
		Node node1=new Node();
		node1.setName("小红");
		node1.setX(7);
		node1.setY(10);
		nodes.add(node1);
		
		Node node2=new Node();
		node2.setName("小武");
		node2.setX(5);
		node2.setY(5);
		nodes.add(node2);
		
		Node node3=new Node();
		node3.setName("小东");
		node3.setX(3);
		node3.setY(10);
		nodes.add(node3);
		
		Node node4=new Node();
		node4.setName("小欠");
		node4.setX(3);
		node4.setY(20);
		nodes.add(node4);
		
		Node node5=new Node();
		node5.setName("小刘");
		node5.setX(4);
		node5.setY(9);
		nodes.add(node5);
		
		Node node6=new Node();
		node6.setName("小孙");
		node6.setX(5);
		node6.setY(10);
		nodes.add(node6);
		
		long start=System.currentTimeMillis();
		
		//算法开始
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
