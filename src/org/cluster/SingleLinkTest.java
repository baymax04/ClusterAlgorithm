package org.cluster;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * ���ݾ�γ����ʵ�ֳ��еľ���
 * @author lily
 *
 */
public class SingleLinkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<City> citys=new ArrayList<City>();
		City city0=new City();
		city0.setName("����");
		city0.setX(116.28);
		city0.setY(39.54);
		citys.add(city0);
		
		City city1 = new City();  
        city1.setName("�� ��");  
        city1.setX(121.29);  
        city1.setY(31.14);  
        citys.add(city1);  
          
        City city2 = new City();  
        city2.setName("�� ��");  
        city2.setX(117.11);  
        city2.setY(39.09);  
        citys.add(city2);  
          
        City city3 = new City();  
        city3.setName("�� ��");  
        city3.setX(106.32);  
        city3.setY(29.32);  
        citys.add(city3);  
          
          
        City city4 = new City();  
        city4.setName("������");  
        city4.setX(126.41);  
        city4.setY(45.45);  
        citys.add(city4);  
          
          
        City city5 = new City();  
        city5.setName("�� ��");  
        city5.setX(125.19);  
        city5.setY(43.52);  
        citys.add(city5);  
          
          
        City city6 = new City();  
        city6.setName("�� ��");  
        city6.setX(118.50);  
        city6.setY(32.02);  
        citys.add(city6);  
          
        City city7 = new City();  
        city7.setName("�� ��");  
        city7.setX(114.21);  
        city7.setY(30.37);  
        citys.add(city7);  
          
          
        City city8 = new City();  
        city8.setName("̨ ��");  
        city8.setX(121.31);  
        city8.setY(25.03);  
        citys.add(city8);  
          
        City city9 = new City();  
        city9.setName("�� ��");  
        city9.setX(114.10);  
        city9.setY(22.18);  
        citys.add(city9);  
        
        long start=System.currentTimeMillis();
		System.out.println(start );
		
		SingleLink sing = new SingleLink(citys); //ʵ����һ������
        List<Set<City>> list = sing.compute();  //�㷨��ʼ
        
        long end=System.currentTimeMillis();
		System.out.println(end );
		System.out.println("start-end="+(end-start));
		//����������
        for (Set<City> list0 : list) {  
            System.out.println("=============");  
            for (City city : list0) {  
                System.out.println(city.getName() + " : (" + city.getX()+","+city.getY()+")");  
            }  
        }  
	}

}
