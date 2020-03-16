package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysone.app.model.Noticia;
import com.sysone.app.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		Optional<Noticia> noticiaOpt = repo.findById(1);

		if (noticiaOpt.isPresent()) {
			Noticia noticia = noticiaOpt.get();
			noticia.setDetalle("Detalle actualizado");
			noticia.setEstatus("Activa");
			repo.save(noticia);
		}

		context.close();
	}
}
