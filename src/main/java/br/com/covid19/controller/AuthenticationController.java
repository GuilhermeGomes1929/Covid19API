package br.com.covid19.controller;

import br.com.covid19.exceptions.InvalidUserOrPassException;
import br.com.covid19.security.JwtTokenUtil;
import br.com.covid19.security.JwtUserDetailsService;
import br.com.covid19.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    JwtUserDetailsService userDetailsService;

    @PostMapping
    public Map<String, String> login(@RequestBody User userRequest){
        authenticate(userRequest);
        UserDetails user = userDetailsService.loadUserByUsername(userRequest.getUsername());

        String token = jwtTokenUtil.gerenateToken(user);
        Map<String, String> response = new HashMap<>();
        response.put("Token", token);
        response.put("Autohirities", user.getAuthorities().toString());
        return response;
    }


    private void authenticate(User user){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        }catch (BadCredentialsException e){
            throw new InvalidUserOrPassException();
        }catch (DisabledException e){
            throw new RuntimeException("Usuário desativado.");
        }
    }

}
