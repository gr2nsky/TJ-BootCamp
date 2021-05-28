package mysqlResultTest;

public class ProjectBean {
	
	int no;
	String name;
	String creation;
	
	public ProjectBean(int no, String name, String creation) {
		super();
		this.no = no;
		this.name = name;
		this.creation = creation;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}
	
	

}
