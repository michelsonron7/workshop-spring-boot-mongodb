package br.com.michelsonroncete.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.michelsonroncete.workshopmongo.domain.User;
import br.com.michelsonroncete.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User tobias = new User(null, "Tobias Roncete", "tobias@gmail.com");
		User lp = new User(null, "Lp Vieira", "lp@gmail.com");
		User maria = new User(null, "Maria mar", "maria@gmail.com");
		
		userRepository.saveAll(Arrays.asList(tobias, lp, maria));
	}

}
