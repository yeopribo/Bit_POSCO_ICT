package Pack01;

public class SurveyDTO {
	int id;
	String roll;
	String tool;
	String talk;
	String location;
	int age;
	
	public SurveyDTO(int id, String roll, String tool, String talk, String location, int age) {
		super();
		this.id = id;
		this.roll = roll;
		this.tool = tool;
		this.talk = talk;
		this.location = location;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public String getTalk() {
		return talk;
	}

	public void setTalk(String talk) {
		this.talk = talk;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
}
