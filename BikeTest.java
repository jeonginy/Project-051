class Bike {
	private String color;				
	private int speed;
	private int gear;
// ------------------------------ be able to use only in Bike class	
	public String getColor() {return color;}
	public void setColor(String c) {color = c;}
	public int getSpeed(){ return speed; }
	public void setSpeed(int s) {speed = s;}
	public int getGear() {return gear;}
	public void setGear(int g) {gear= g;}
}

public class BikeTest {
	public static void main(String [] args) {
		Bike b  = new Bike();	
		
		b.setColor("Red");	
		b.setSpeed(100);
		b.setGear(1);
		
		System.out.println(b.getColor());	
		System.out.println(b.getSpeed());
		System.out.println(b.getGear());
		
	}
	
	
}





