package br.com.covid19.exceptions;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

public class InvalidUserOrPassException extends BadCredentialsException {

    public InvalidUserOrPassException(){
        super(null);
    }

    public InvalidUserOrPassException(String msg) {
        super(msg);
    }

    public InvalidUserOrPassException(String msg, Throwable cause) {
        super(msg, cause);
    }

    @Override
    public String getMessage() {
        return "Usuário ou senha inválida.";
    }
}