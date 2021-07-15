package br.com.covid19.controller;

import br.com.covid19.security.JwtTokenUtil;
import br.com.covid19.security.JwtUserDetailsService;
import br.com.covid19.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    public Map<String, String> login(@RequestBody User user){
        authenticate(user.getUsername(), user.getPassword());
        String token = jwtTokenUtil.gerenateToken(userDetailsService.loadUserByUsername(user.getUsername()));
        Map<String, String> response = new HashMap<>();
        response.put("Token", token);
        return response;
    }


    private void authenticate(String username, String password){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (BadCredentialsException e){
            throw new RuntimeException("Credenciais inválidas.");
        }catch (DisabledException e){
            throw new RuntimeException("Usuário desativado.");
        }
    }

}
