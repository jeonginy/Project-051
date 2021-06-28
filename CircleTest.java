/*	print하는 방법
 * 1. 메소드를 생성 후, 객체 생성하고 호출
 * 2. toString() 생성 후, print
 * 3. static메소드 생성 후, 호출  
 */


public class CircleTest {

	public static void main(String[] args) {
//	Create Circle object & initialize
	Point p = new Point(25, 78);
	Circle c = new Circle(p, 10);	//	As create Circle object, pass the value of Point object
	
	int[] c1 = p.mee();	//	메소드 호출
	System.out.println(c1[0] + "  " + c1[1]);		//	배열 뽑아내는 방법 : String 취급
	}

}


//	Create Circle class
class Circle {
	private int radius = 0;
	private Point center;	//	Defined Point value in Field
	
//	Create Circle constructor
	public Circle(Point p, int r) {
		center = p;
		radius = r;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", center=" + center + "]";
	}
	
	
}

//	Create Point class
class Point {
	private int x, y;
	public Point(int a, int b) {
		x = a;
		y = b;
	}
	
	public int[] mee() {
		int[] c = new int[2];
		c[0] = this.x;
		c[1] = this.y;
		
		return c;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}