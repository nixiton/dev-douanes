package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.douane.entite.Agent;
import com.douane.entite.Useri;
import com.douane.metier.referentiel.IRefMetier;
import com.douane.metier.user.IUserMetier;

public class TestInitializeDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		System.out.println("BEGIN DB INITIALIZATION");
		
		IRefMetier metier = (IRefMetier) context.getBean("refmetier");
		
		IUserMetier usermetier = (IUserMetier) context.getBean("usermetier");
		Useri toor = new Useri("Un utilisateur qui peut tout faire", "toor");
		usermetier.addUser(toor);
		Agent admin = new Agent(1L, "ADMINISTRATEUR", "toor", toor);
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("123456");
		
		admin.setPassword(hashedPassword);
		usermetier.addAgent(admin);
	}

}
