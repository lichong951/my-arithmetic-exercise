package top.lc951.arithmetic;

import java.util.Arrays;

/**
 * 桶排序法
 * */
public class Paixu {

	
	 private static int [] ContainerPaixu(int [] array)
	      {
	         int num = array.length;
	         int [] container = new int[1000];  //输入数据在1000以内
	         Arrays.fill(container, 0);
	         
	         for(int i=0;i<num;i++)
	         {
	             int index = array[i];
	              container[index] ++;
	          }
	        
	       //输出排序后的结果
	        for(int i=0;i<container.length;i++)
	                 {
	                     if(container[i]!= 0)
	                    {
	                         for(int j=0;j<container[i];j++)
	                         {
	                             System.out.print(i+" ");
	                         }
	                    }
	                 }
	         return container;
	   }
}
