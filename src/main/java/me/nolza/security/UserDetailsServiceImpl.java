package me.nolza.security;

import lombok.extern.slf4j.Slf4j;
import me.nolza.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by gain on 2017. 8. 14..
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("===============loadUserByeamil"+ email);
        System.out.println("user: " + this.userRepository.findByEmail(email));
        UserDetails userDetails = new UserDetailsImpl(this.userRepository.findByEmail(email));
        System.out.println("userdetails: " + userDetails);

        return userDetails;
    }
}
