package common;

public class Participant {
	private String name;
	private String position;
	private String company;
	private int age;

	public Participant(String name, String position, String company, int age) {
		this.name = name;
		this.position = position;
		this.company = company;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public String getCompany() {
		return company;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "\nParticipant -> { " +
			"name='" + name + '\'' +
			", position='" + position + '\'' +
			", company='" + company + '\'' +
			", age=" + age +
			" }";
	}
}
