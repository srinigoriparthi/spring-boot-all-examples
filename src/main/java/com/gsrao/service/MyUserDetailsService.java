package com.gsrao.service;

import com.gsrao.config.SecurityConfiguration;
import com.gsrao.dao.PersonRepository;
import com.gsrao.dao.UserRepository;
import com.gsrao.model.MyUserDetails;
import com.gsrao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        //user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        if(user.isPresent()){
            LOGGER.info("User found in User JPA DB !!"+userName);
            return user.map(MyUserDetails::new).get();
        }else{
            LOGGER.warn("User not found in User JPA DB !!"+userName);
            throw new UsernameNotFoundException("Not found: " + userName);
        }

    }
}
