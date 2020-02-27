public class Course {

	private String title;
	private String number;
	private String description;
	private int creaditHour;

	public Course(){

	}

	public Course(String title, String number, String description, int creaditHour){
		this.title = title;
		this.number = number;
		this.description = description;
		this.creaditHour = creaditHour;

	}

	public String getTitle() {
		return title;
	}

	public String getNumber() {
		return number;
	}

	public String getDescription() {
		return description;
	}

	public int getCreaditHour() {
		return creaditHour;
	}
}
