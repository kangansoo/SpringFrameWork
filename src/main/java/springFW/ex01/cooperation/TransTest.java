package springFw.ex01.cooperation;

public class TransTest {
	
	public static void main(String[] args) {
		GeneralPassenger pass1 = new GeneralPassenger(10000);
		pass1.showInfo();

		GeneralPassenger pass2 = new GeneralPassenger("승객2", 10000);
		pass2.showInfo();
		
		Bus bus100 = new Bus(100);
		bus100.showInfo();
		
		
		Bus bus200 = new Bus(200);
		bus200.showInfo();
		
		bus100.getIn(pass1);
		bus100.getOut(pass1);
		
		bus200.getIn(pass1);
		bus200.getOut(pass1);

		bus100.getIn(pass2);
		bus100.getOut(pass2);
		
		Student stud = new Student("학생1", 20000);
		
		bus200.getIn(stud);
		bus200.getOut(stud);
		
	}
	
}
