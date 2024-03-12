package com.Ecommerce.User.Security;

import com.Ecommerce.User.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepo userRepository;
	
	public CustomUserDetailsService(UserRepo userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
	}

	
}
