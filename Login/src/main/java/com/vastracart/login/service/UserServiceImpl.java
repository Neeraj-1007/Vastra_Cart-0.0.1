package com.vastracart.login.service;

import com.vastracart.login.Entity.User;
import com.vastracart.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceInt, UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Autowired(required=true)
    private BCryptPasswordEncoder pwdEncoder;


    @Override
    public Integer saveUser(User user) {
        user.setPassword(pwdEncoder.encode(user.getPassword()));

        repo.save(user);
        return user.getId();
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return repo.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = findByUserName(username);

        if (opt == null) {
            return (UserDetails) new UsernameNotFoundException("User not exist");
        }

        User user = opt.get();
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                user.getRole()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role))
                        .collect(Collectors.toSet()));
    }
}
