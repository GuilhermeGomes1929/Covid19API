package br.com.covid19.security;

import br.com.covid19.model.User;
import br.com.covid19.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);


        if (user == null){ throw new UsernameNotFoundException("Usuário "+username+ " não encontrado.");}

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.get().getUsername())
                .password(user.get().getPassword())
                .disabled(false)
                .authorities(user.get().getAuthorities()).build();

        return userDetails;
    }
}
