package io.darklyn.musicoteca.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.darklyn.musicoteca.exceptions.ConflictException;

@CrossOrigin
@RestController
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		ResponseEntity<User> response;
		
		try {
			User u = authService.createUser(user.getEmail(), user.getPassword(), user.getNome());
			response = new ResponseEntity<>(u, HttpStatus.OK);
		} catch (ConflictException ce) {
			response = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return response;
		
	}
	
//	@RequestMapping(method=RequestMethod.OPTIONS, value="/login")
//	public ResponseEntity<?> login2() {
//		return login();
//	}
//	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public ResponseEntity<SerialUserDetails> login(@AuthenticationPrincipal SerialUserDetails userDetails) {
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}
}
