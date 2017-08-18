package com.demos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SingleLinkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> persons=new ArrayList<Person>();
		
		Person person0=new Person();
		person0.setName("����");
		person0.setAge(20);
		person0.setIncome(350);
		persons.add(person0);
		
		Person person1=new Person();
		person1.setName("�ź�");
		person1.setAge(25);
		person1.setIncome(850);
		persons.add(person1);
		
		Person person2=new Person();
		person2.setName("��˧");
		person2.setAge(28);
		person2.setIncome(950);
		persons.add(person2);
		
		
		Person person3=new Person();
		person3.setName("����");
		person3.setAge(20);
		person3.setIncome(450);
		persons.add(person3);
		
		Person person4=new Person();
		person4.setName("��˧");
		person4.setAge(25);
		person4.setIncome(550);
		persons.add(person4);
		
		Person person5=new Person();
		person5.setName("��Ѽ�");
		person5.setAge(30);
		person5.setIncome(750);
		persons.add(person5);
		
		Person person6=new Person();
		person6.setName("����");
		person6.setAge(29);
		person6.setIncome(550);
		persons.add(person6);
		
		Person person7=new Person();
		person7.setName("��ˬ");
		person7.setAge(24);
		person7.setIncome(850);
		persons.add(person7);
		
		Person person8=new Person();
		person8.setName("ŷ��ѩ");
		person8.setAge(35);
		person8.setIncome(850);
		persons.add(person8);
		
		Person person9=new Person();
		person9.setName("����");
		person9.setAge(22);
		person9.setIncome(650);
		persons.add(person9);
		
		Person person10=new Person();
		person10.setName("������");
		person10.setAge(26);
		person10.setIncome(750);
		persons.add(person10);
		
		long start=System.currentTimeMillis();
		//ʵ����һ������
		SingleLink singleLink=new SingleLink(persons);
		List<Set<Person>> lSets=singleLink.compute();//�㷨��ʼ
//		System.out.println("zhixing??");
		long end =System.currentTimeMillis();
		System.out.println("end-start="+(end-start));
		
		//��ǿfor����
		for(Set<Person> set:lSets){
			System.out.println("**********************");
			for(Person p:set){
				System.out.println(p.getName()+"\t("+p.getAge()+",\t"+p.getIncome()+")");
			}
			
		}
		
		
	}

}
