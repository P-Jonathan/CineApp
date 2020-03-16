package pruebasjparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import com.sysone.app.model.Noticia;
import com.sysone.app.repository.NoticiasRepository;

public class AppFindAllAndSort {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Busco las noticias y las ordeno descendentemente por el titulo
		// List<Noticia> noticias = repo.findAll(Sort.by("titulo").descending());

		// Busco las noticias y las ordeno ascendentmente por fecha y descendentemente
		// por el id
		List<Noticia> noticias = repo.findAll(Sort.by("fecha").ascending().and(Sort.by("id").descending()));

		noticias.forEach(System.out::println);

		context.close();
	}
}
