package br.com.michelsonroncete.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.michelsonroncete.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		var tobias = new User("1", "Tobias roncete", "tobias@gmail.com");
		var lp = new User("2", "Lp roncete", "lp@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(tobias, lp));
		return ResponseEntity.ok().body(list);
	}
}
