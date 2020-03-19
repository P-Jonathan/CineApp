package pruebasquery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.model.Noticia;
import com.sysone.app.repository.NoticiasRepository;

public class AppFindByOr {
	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// List<Noticia> noticias = repo.findByEstatus("Inactiva");
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		List<Noticia> noticias = repo.findByEstatusOrFecha("Inactiva", format.parse("23-03-2020"));

		noticias.forEach(System.out::println);

		context.close();
	}
}
