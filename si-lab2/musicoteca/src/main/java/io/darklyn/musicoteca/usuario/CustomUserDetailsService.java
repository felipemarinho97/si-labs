package io.darklyn.musicoteca.usuario;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	public UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(username);
        
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        
		return new SerialUserDetails(user.getEmail(), user.getPassword(), new ArrayList<GrantedAuthority>(), user.getId(), user.getNome());
	}

}
