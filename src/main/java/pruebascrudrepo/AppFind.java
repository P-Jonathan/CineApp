package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.model.Noticia;
import com.sysone.app.repository.NoticiasRepository;

public class AppFind {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		Noticia noticia = repo.findById(1).get();

		System.out.println("Noticia buscada: " + noticia);

		context.close();
	}
}
