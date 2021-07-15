package inter2;

public interface Days {
	int MONDAY = 1;
	int TUESDAY = 2;
	int WEDNESDAY = 3;
	int THURSDAY = 4;
	int FRIDAY = 5;
	int SATURDAY = 6;
	int SUNDAY = 7;
	
}

class Date {
	int year;
	int month;
	int day;
	int dayOfWeek;

	public Date(int year, int month, int day, int dayOfWeek) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.dayOfWeek = dayOfWeek;
	}
}



