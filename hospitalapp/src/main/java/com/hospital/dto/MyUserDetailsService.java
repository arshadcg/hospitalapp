package com.hospital.dto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospital.repos.UserDtoRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	@Autowired UserDtoRepository userDtoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<UserDto> user =userDtoRepository.findByUserName(userName);
		user.orElseThrow(()->new UsernameNotFoundException("Not Found"+userName));
		
		return user.map(MyUserDetails::new).get();
	}

}
