package com.example.cortiliabe.security.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.cortiliabe.security.entity.UserDAO;
import com.example.cortiliabe.security.entity.dto.UserDTO;
import com.example.cortiliabe.security.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepository.findByUsername(username).isPresent()) {
            return new User(username,userRepository.findByUsername(username).get().getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UserDAO save(UserDTO user) {
        UserDAO newUserDAO = new UserDAO();
        newUserDAO.setUsername(user.getUsername());
        newUserDAO.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(newUserDAO);
    }

}