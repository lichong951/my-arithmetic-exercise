package top.lc951.arithmetic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiagonalOrderTest {

	@Test
	void test() {
		int[][] matrix= {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int[] result=DiagonalOrder.process(matrix);
		String resultStr="";
		for(int i=0;i<result.length;++i) {
			resultStr+=String.valueOf(result[i]);
		}
		
		assertEquals("124753689", resultStr);
	}
	
	@Test
	void arithmetic1() {
		int[][] matrix= {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int[] result=DiagonalOrder.arithmetic1(matrix);
		String resultStr="";
		for(int i=0;i<result.length;++i) {
			resultStr+=String.valueOf(result[i]);
		}
		
		assertEquals("124753689", resultStr);
	}

}
