import java.math.BigInteger;

/* 다음과 같은 피보나치 수열을 출력해보세요.
 * 1 1 2 3 5 8 13 21 34 ... 
 * 
 * 정수 100개 

i	sum		a		b
0	1		0		1	
1	2		1		1
2	3		3		1
3	5		5		3	
4	8		8		5
5	13		13		8
6	21		21		13
7	34		55		21
*/

public class Fibonacci {

	public static void main(String[] args) {
		BigInteger a1 = BigInteger.valueOf(1);
		BigInteger a2 = BigInteger.valueOf(1);
		BigInteger a3;
		
		
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		
		
		for( int i = 0; i < 100; i++ ) {
			a3 = new BigInteger(a1.add(a2).toString());
			a1 = new BigInteger(a2.toString());
			a2 = new BigInteger(a3.toString());
			
			System.out.println(a3.toString());
		
		}
		
		
		
	}

}
