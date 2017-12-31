package io.darklyn.musicoteca.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.darklyn.musicoteca.exceptions.ConflictException;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	private BCryptPasswordEncoder bcryptpsse = new BCryptPasswordEncoder();
	
	public User createUser(String email, String password, String nome) {
		if (userRepository.existsByEmail(email)) {
			throw new ConflictException("Usuário existente!");
		}
		String encpss = bcryptpsse.encode(password);

		User u = new User(email, encpss, nome);
		return userRepository.save(u);
	}
}
