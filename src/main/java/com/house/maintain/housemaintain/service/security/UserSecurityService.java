package com.house.maintain.housemaintain.service.security;

import com.house.maintain.housemaintain.repository.UserRepository;
import com.house.maintain.housemaintain.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserVO usersVO = userRepository.findByUsername(s);
        if(usersVO == null){
            throw new UsernameNotFoundException("User not found");
        }
        return usersVO;
    }
}
