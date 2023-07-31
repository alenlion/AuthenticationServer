package com.kalem.authenticationserver.user.service;

import com.kalem.authenticationserver.user.model.UserEntity;
import com.kalem.authenticationserver.user.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Rayan Aksu
 * @since 7/28/2023
 */


@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailService( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {

        String userName, password = null;
        List<GrantedAuthority> authorities = null;
        Optional<UserEntity> user = userRepository.findByUsername( username );
        if ( user.isEmpty() ) {
            throw new UsernameNotFoundException( "User details not found for the user : " + username );
        } else {

            userName = user.get().getUsername();
            password = user.get().getPassword();
            authorities = new ArrayList<>();
            authorities.add( new SimpleGrantedAuthority( user.get().getRole() ) );
        }
        return new User( userName, password, authorities );
    }
}
