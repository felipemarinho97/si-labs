package io.darklyn.musicoteca.usuario;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findOneByEmail(String email);
	boolean existsByEmail(String email);

}
