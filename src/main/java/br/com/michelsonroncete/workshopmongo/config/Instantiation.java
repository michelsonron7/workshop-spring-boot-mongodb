package br.com.michelsonroncete.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.michelsonroncete.workshopmongo.domain.Post;
import br.com.michelsonroncete.workshopmongo.domain.User;
import br.com.michelsonroncete.workshopmongo.dto.AuthorDTO;
import br.com.michelsonroncete.workshopmongo.repository.PostRepository;
import br.com.michelsonroncete.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		var sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		var tobias = new User(null, "Tobias Roncete", "tobias@gmail.com");
		var lp = new User(null, "Lp Vieira", "lp@gmail.com");
		var maria = new User(null, "Maria mar", "maria@gmail.com");
		
		userRepository.saveAll(Arrays.asList(tobias, lp, maria));
		
		var post1 = new Post(null, sdf.parse("14/06/2023"), "Partiu viagem", "Vou viajar para Bahia. Abraços!", new AuthorDTO(maria));
		var post2 = new Post(null, sdf.parse("15/06/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
