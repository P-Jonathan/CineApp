package pruebascrudrepo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.model.Noticia;
import com.sysone.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		List<Integer> ids = new LinkedList<Integer>(Arrays.asList(1, 4, 6));

		Iterable<Noticia> noticias = repo.findAllById(ids);

		noticias.forEach(System.out::println);

		context.close();
	}
}
