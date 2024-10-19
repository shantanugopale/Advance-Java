import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	private int lid;
	private String lname;
	private String color;
	
	@OneToOne
	private EmployeeRelation emp;
	
	public EmployeeRelation getEmp() {
		return emp;
	}
	public void setEmp(EmployeeRelation emp) {
		this.emp = emp;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
