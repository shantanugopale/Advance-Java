import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestMain {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		EmployeeRelation e1 = new EmployeeRelation();
		e1.setEid(101);
		e1.setName("Shantanu");
		
		Laptop l1 = new Laptop();
		l1.setLid(111);
		l1.setLname("DELL");
		l1.setColor("Black");
		
		e1.setLaptop(l1);
		l1.setEmp(e1);
		
		session.save(e1);
		session.save(l1);
		
		txn.commit();
		System.out.println("Record Saved...!!!");
		
		

	}

}
