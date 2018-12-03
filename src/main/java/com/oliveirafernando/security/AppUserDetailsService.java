package com.oliveirafernando.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oliveirafernando.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<com.oliveirafernando.model.User> userOpt = this.userRepository.findByEmail(email);
		
		com.oliveirafernando.model.User user = userOpt
				.orElseThrow(() -> new UsernameNotFoundException("User/Password incorrect"));

		return new UserSystem(user, getPermissions(user));
	}

	private Collection<? extends GrantedAuthority> getPermissions(com.oliveirafernando.model.User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		
		user.getPermissions()
				.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
		
		return authorities;
	}

}
