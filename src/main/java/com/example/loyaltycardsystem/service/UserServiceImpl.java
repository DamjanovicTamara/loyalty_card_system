package com.example.loyaltycardsystem.service;


import com.example.loyaltycardsystem.domain.User;
import com.example.loyaltycardsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user from the database (throw exception if not found)
        User user = userRepository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Return user object
        return user;
    }

    @Override
    public UserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails details = (UserDetails) authentication.getDetails();
        return details;
    }
}
