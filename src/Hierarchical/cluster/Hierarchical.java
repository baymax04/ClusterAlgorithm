package Hierarchical.cluster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

/**
 * ����ʽ��ξ����㷨Ҳ��һ�������Ĺ��̣��㷨�������£�
ÿ��ѡ����������غϲ������ǽ��������ϲ���Ĵس�֮Ϊ�ϲ��ء�
������ MAX ׼��ѡ����������ϲ����������Զ��������֮��ľ�����Ϊ��֮����ڽ��ȡ�
������ MIN ׼��ȡ��������ϲ�������������������֮��ľ�����Ϊ��֮����ڽ��ȡ�
����ƽ��׼��ȡ��������ϲ������е�֮������ƽ��ֵ��Ϊ��֮����ڽ��ȡ�
�ظ����� 1 �Ͳ��� 2���ϲ���ֻʣ��һ���ء�
 * @author lily
 *
 */
public class Hierarchical {

	private double[][] matrix;
	private int dimension;//����ά��
	
	private class Node{
		double[] datas;
		public Node() {
			datas=new double[100];
		}
	}
	
	
	private ArrayList<Node> arrayList;
	private class Model{
		int x=0;
		int y=0;
		double value=0;
	}
	private Model minModel=new Model();
	
	//��������
	private double getDistance(Node one,Node two){
		double val=0;
		for(int i=0;i<dimension;++i){
			val+=Math.pow((one.datas[i]-two.datas[i]),2);
		}
		return Math.sqrt(val);
	}
	
	
	//����������ת��Ϊ����
	private void loadMatrix(){
		for(int i=0;i<matrix.length;++i){
			for(int j=i+1;j<matrix.length;++j){
				double distance=getDistance(arrayList.get(i), arrayList.get(j));
				matrix[i][j]=distance;
			}
		}
	}
	
	//�ҳ������������������
	private Model findMinValeOfMatrix(double[][] matrix){
		Model model=new Model();
		double min=0x7fffffff;
		for(int i=0;i<matrix.length;++i){
			for(int j=i+1;j<matrix.length;++j){
				if(min>matrix[i][j]&&matrix[i][j]!=0){
					min=matrix[i][j];
					model.x=i;
					model.y=j;
					model.value=matrix[i][j];
				}
			}
		}
		return model;
	}
	
	private void processHierarchical(String path){
		try {
			PrintStream out=new PrintStream(path);
			
			while(true){ //���۲�ξ������
				out.println("-----------------�����������-------------------");
				//���ÿ�ε������µľ���
				for(int i=0;i<matrix.length;++i){
					for(int j=0;j<matrix.length-1;++j){
						out.print(new DecimalFormat("#.00").format(matrix[i][j])+" ");
					}
					out.println(new DecimalFormat("#.00").format(matrix[i][matrix.length-1])+" ");
				}
				out.println();
				minModel=findMinValeOfMatrix(matrix);
				
				if(minModel.value==0){//���Ҳ������������������ʱ����������
					break;
				}
				
				out.print("combine"+(minModel.x+1)+" "+(minModel.y+1)+" ");
				out.println("�����ǣ�"+minModel.value);
				
				//���¾���
				matrix[minModel.x][minModel.y]=0;
				// ����ϲ��˵� p1 �� p2����ֻ���� p1,p2 ����֮һ��������ľ��룬ȡ��Сֵ
				for(int i=0;i<matrix.length;++i){ 
					if(matrix[i][minModel.x]<=matrix[i][minModel.y]){
						matrix[i][minModel.y]=0;
					}else {
						matrix[i][minModel.x]=0;
					}
					
					if(matrix[minModel.x][i]<=matrix[minModel.y][i]){
						matrix[minModel.y][i]=0;
					}else {
						matrix[minModel.x][i]=0;
					}
				}
			}
			
			out.close();
			System.out.println("��������"+path);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public void setInput(String path){
		try {
			BufferedReader br=new BufferedReader(new FileReader(path));
			String str;
			String[] strArray;
			arrayList=new ArrayList<>();
			while((str=br.readLine())!=null && str!=""){
				strArray=str.split(",");
				dimension=strArray.length;
				Node node=new Node();
				for(int i=0;i<dimension;++i){
					node.datas[i]=Double.parseDouble(strArray[i]);
				}
				arrayList.add(node);
			}
			
			matrix=new double[arrayList.size()][arrayList.size()];
			loadMatrix();
			br.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void printOutput(String path){
		processHierarchical(path);
	}
	
	public static void main(String[] args) {
		Hierarchical h=new Hierarchical();
//		h.setInput("f:/Hierarchical.txt");
//		h.printOutput("f:/Hierarchical_results.txt");
		
		h.setInput("src\\Hierarchical\\cluster\\Hierarchical.txt");
		h.printOutput("src\\Hierarchical\\cluster\\Hierarchical_results.txt");
	}
	
}
