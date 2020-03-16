package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.sysone.app.model.Noticia;
import com.sysone.app.repository.NoticiasRepository;

public class AppPagingAndSort {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		Page<Noticia> paging = repo.findAll(PageRequest.of(1, 5, Sort.by("titulo").ascending()));

		paging.forEach(System.out::println);

		context.close();
	}
}
