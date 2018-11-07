package top.lc951.arithmetic;
/**
 * 对角线遍历
 * 输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]
 * */
public class DiagonalOrder {

	public static int[] process(int[][] matrix) {
		
		int i=0;
		int j=0;
		boolean isUp=true;
		boolean isDown=false;
		if(matrix.length==0) {
			return new int[0];
		}
        int [] result=new int[matrix.length*matrix[0].length];
		for(int count=0;count<matrix.length*matrix[0].length;count++) {
			if(i>=matrix.length||j>=matrix[i].length) {
					System.out.print("Error = ["+i+","+j+"],");
					break;
            }
			System.out.print(matrix[i][j]+" = ["+i+","+j+"],");
            result[count]=matrix[i][j];
           
			if(isUp) {
				if(i-1>=0&&j+1<matrix[i].length) {
					i--;
					j++;
				}else
				{
					isUp=false;
					isDown=true;
					System.out.println();
					if(j+1<matrix[i].length) {
						j++;
					}else {
						i++;
					}
					
				}
			}else if(isDown) {
				if(j-1>=0&&i+1<matrix.length) {
					j--;
					i++;
				}else {
					System.out.println();
					isDown=false;
					isUp=true;
					if(i+1<matrix.length) {
						i++;
					}else {
						j++;
					}
				}
			}
		}
		System.out.println();
        return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix= {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int[] result=process(matrix);
		System.out.println("=================");
		System.out.println(String.valueOf(result));
		System.out.println("=================");
		
		
		int [][] matrix1= {{1}};
			result=process(matrix1);
			System.out.println("=================");
			System.out.println(String.valueOf(result));
			
			int[][] matrix2= {
					{1, 2, 3, 4},
					{5, 6, 7, 8},
					{9,10,11,12},
					{13,14,15,16}
			};
			result=process(matrix2);

			int[][] matrix3=new int[0][0];
			result=process(matrix3);
	}
	/**
	 * 这道题给了我们一个mxn大小的数组，让我们进行对角线遍历，
	 * 先向右上，然后左下，再右上，以此类推直至遍历完整个数组，题目中的例子和图示也能很好的帮我们理解。
	 * 由于移动的方向不再是水平或竖直方向，而是对角线方向，那么每移动一次，横纵坐标都要变化，
	 * 向右上移动的话要坐标加上[-1, 1]，向左下移动的话要坐标加上[1, -1]，那么难点在于我们如何处理越界情况，
	 * 越界后遍历的方向怎么变换。向右上和左下两个对角线方向遍历的时候都会有越界的可能，
	 * 但是除了左下角和右上角的位置越界需要改变两个坐标之外，其余的越界只需要改变一个。
	 * 那么我们就先判断要同时改变两个坐标的越界情况，即在右上角和左下角的位置。
	 * 如果在右上角位置还要往右上走时，那么要移动到它下面的位置的，那么如果col超过了n-1的范围，
	 * 那么col重置为n-1，并且row自增2，然后改变遍历的方向。同理如果row超过了m-1的范围，那么row重置为m-1，
	 * 并且col自增2，然后改变遍历的方向。然后我们再来判断一般的越界情况，如果row小于0，那么row重置0，
	 * 然后改变遍历的方向。同理如果col小于0，那么col重置0，然后改变遍历的方向
	 * 
	 * */
	public static int[] arithmetic1(int[][] matrix) {
		if(0==matrix.length||0==matrix[0].length)
			return new int[]{};
		
		int m=matrix.length;
		int n=matrix[0].length;
		int c=0;
		int r=0;
		int k=0;
		
		int[] res=new int[m*n];
		int[][] dirs= {
				{-1,1},
				{1,-1}
		};
		
		for(int i=0;i<m*n;++i) {
			res[i]=matrix[r][c];
			r+=dirs[k][0];
			c+=dirs[k][1];
			if(r>=m) {
				r=m-1;
				c+=2;
				k=1-k;
			}
			if(c>=n) {
				c=n-1;
				r+=2;
				k=1-k;
			}
			if(r<0) {
				r=0;
				k=1-k;
			}
			
			if(c<0) {
				c=0;
				k=1-k;
			}
			
		}
		return res;
		
	}
	
	

}
