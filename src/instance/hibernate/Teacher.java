package instance.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {

	private int id;
	private String name;
	private String project;
	

	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	
	
}
