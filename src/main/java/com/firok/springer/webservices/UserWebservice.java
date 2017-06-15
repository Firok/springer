package com.firok.springer.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.firok.springer.entities.User;
import com.firok.springer.services.IUserService;

@Controller
@RequestMapping("users")
public class UserWebservice {

	@Autowired
	private IUserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> userList = userService.findAll();

		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {

		User user = userService.find(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder) {

		boolean flag = userService.addUser(user);

		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		user = userService.update(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") long id) {
		userService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
