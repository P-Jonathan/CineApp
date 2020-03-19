package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.model.Pelicula;
import com.sysone.app.repository.PeliculasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);

		List<Pelicula> peliculas = repo.findAll();

		peliculas.forEach(System.out::println);

		context.close();
	}

}
