package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.model.Horario;
import com.sysone.app.repository.HorariosRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		HorariosRepository repo = context.getBean("horariosRepository", HorariosRepository.class);

		List<Horario> detalles = repo.findAll();

		detalles.forEach(System.out::println);

		context.close();
	}
}
