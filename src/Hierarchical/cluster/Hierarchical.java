package Hierarchical.cluster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

/**
 * 凝聚式层次聚类算法也是一个迭代的过程，算法流程如下：
每次选最近的两个簇合并，我们将这两个合并后的簇称之为合并簇。
若采用 MAX 准则，选择其他簇与合并簇中离得最远的两个点之间的距离作为簇之间的邻近度。
若采用 MIN 准则，取其他簇与合并簇中离得最近的两个点之间的距离作为簇之间的邻近度。
若组平均准则，取其他簇与合并簇所有点之间距离的平均值作为簇之间的邻近度。
重复步骤 1 和步骤 2，合并至只剩下一个簇。
 * @author lily
 *
 */
public class Hierarchical {

	private double[][] matrix;
	private int dimension;//数据维度
	
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
	
	//两点间距离
	private double getDistance(Node one,Node two){
		double val=0;
		for(int i=0;i<dimension;++i){
			val+=Math.pow((one.datas[i]-two.datas[i]),2);
		}
		return Math.sqrt(val);
	}
	
	
	//将输入数组转化为矩阵
	private void loadMatrix(){
		for(int i=0;i<matrix.length;++i){
			for(int j=i+1;j<matrix.length;++j){
				double distance=getDistance(arrayList.get(i), arrayList.get(j));
				matrix[i][j]=distance;
			}
		}
	}
	
	//找出矩阵中最近的两个簇
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
			
			while(true){ //凝聚层次聚类迭代
				out.println("-----------------矩阵更新如下-------------------");
				//输出每次迭代更新的矩阵
				for(int i=0;i<matrix.length;++i){
					for(int j=0;j<matrix.length-1;++j){
						out.print(new DecimalFormat("#.00").format(matrix[i][j])+" ");
					}
					out.println(new DecimalFormat("#.00").format(matrix[i][matrix.length-1])+" ");
				}
				out.println();
				minModel=findMinValeOfMatrix(matrix);
				
				if(minModel.value==0){//当找不出距离最近的两个簇时，迭代结束
					break;
				}
				
				out.print("combine"+(minModel.x+1)+" "+(minModel.y+1)+" ");
				out.println("距离是："+minModel.value);
				
				//更新矩阵
				matrix[minModel.x][minModel.y]=0;
				// 如果合并了点 p1 与 p2，则只保留 p1,p2 其中之一与其他点的距离，取较小值
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
			System.out.println("请检查结果："+path);
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
