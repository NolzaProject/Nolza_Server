package me.nolza.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.nolza.controller.model.request.UserRequest;
import me.nolza.domain.User;
import me.nolza.repository.RoleRepository;
import me.nolza.repository.UserRepository;
import me.nolza.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


/**
 * Created by gain on 2017. 8. 14..
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //TODO 현재 로그인 된 유저 아이디 찾는 기능 구현

    @Override
    public void createUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setNation(userRequest.getNation());
        user.setUserName(userRequest.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        user.setDuration(userRequest.getDuration());
        user.addRoles(this.roleRepository.findByRole("ROLE_USER"));
        userRepository.save(user);
    }

    @Override
    public String loginUser(UserRequest userRequest, HttpSession session){
        UserDetails userDetails = userDetailsService.loadUserByUsername(userRequest.getEmail());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword());

        try {
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        return session.getId();
    }

}
