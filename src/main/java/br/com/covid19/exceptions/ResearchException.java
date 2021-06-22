package br.com.covid19.exceptions;

public class ResearchException extends RuntimeException{
    public ResearchException(String message) {
        super(message);
    }

    public ResearchException(){
        super();
    }
}
