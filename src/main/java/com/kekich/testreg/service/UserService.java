package com.kekich.testreg.service;

import com.kekich.testreg.model.User;
import com.kekich.testreg.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return (UserDetails) user;
    }

    @Transactional
    public User login(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        } else {
            if (!user.getPassword().equals(password)) {
                throw new BadCredentialsException("Wrong password");
            } else {
                return user;
            }
        }

    }

}
