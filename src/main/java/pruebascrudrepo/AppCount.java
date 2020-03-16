package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.repository.NoticiasRepository;

public class AppCount {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		long count = repo.count();
		
		System.out.println("Se encontraron " + count  + " registros.");
		
		context.close();
	}
}
