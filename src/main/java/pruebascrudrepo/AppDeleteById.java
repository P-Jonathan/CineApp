package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.repository.NoticiasRepository;

public class AppDeleteById {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		int id = 3;

		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
		context.close();
	}
}
