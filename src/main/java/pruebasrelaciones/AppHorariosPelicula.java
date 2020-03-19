package pruebasrelaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.model.Pelicula;
import com.sysone.app.repository.PeliculasRepository;

public class AppHorariosPelicula {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);

		Pelicula pelicula = repo.findById(5).get();

		pelicula.getHorarios().forEach(System.out::println);

		context.close();
	}
}
