import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmployeeRelation {
	@Id
	private int eid;
	private String name;
	
	@OneToOne
	private Laptop laptop;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "EmployeeRelation [eid=" + eid + ", name=" + name + ", laptop=" + laptop + "]";
	}
	
	
}
