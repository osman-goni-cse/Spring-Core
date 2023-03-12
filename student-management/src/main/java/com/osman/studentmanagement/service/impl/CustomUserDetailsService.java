package com.osman.studentmanagement.service.impl;

import com.osman.studentmanagement.entity.User;
//import org.springframework.security.core.userdetails.User;
import com.osman.studentmanagement.repository.UserRepository;
import com.osman.studentmanagement.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User With This Email Not Found");
        }
        return new CustomUserDetails(user);
    }
}
