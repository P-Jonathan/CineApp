package pruebasquery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.model.Noticia;
import com.sysone.app.repository.NoticiasRepository;

public class AppFindByBetween {
	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// List<Noticia> noticias = repo.findByEstatus("Inactiva");
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		List<Noticia> noticias = repo.findByFechaBetween(format.parse("11-03-2020"), format.parse("16-03-2020"));
		// format.parse("16-03-2020"));
		// List<Noticia> noticias = repo.findByIdBetween(5, 8);

		noticias.forEach(System.out::println);

		context.close();
	}
}
