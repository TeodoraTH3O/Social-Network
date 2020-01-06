package com.sda.service;

import com.sda.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Iterable<User> findAll() {

        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(email);
        if(!byEmail.isPresent()){
            throw new UsernameNotFoundException("User not found");
        }
        User user = byEmail.get();
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getAuthorities(user));
    }

    private List getAuthorities (User user) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_" + "USER"));
        //TODO replace USER string with user.getRole() as soon as multiple roles are implemented - register with role.
        return simpleGrantedAuthorities;


    }


}
