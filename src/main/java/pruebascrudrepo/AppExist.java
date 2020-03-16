package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.repository.NoticiasRepository;

public class AppExist {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		System.out.println(repo.existsById(1));

		context.close();
	}
}
