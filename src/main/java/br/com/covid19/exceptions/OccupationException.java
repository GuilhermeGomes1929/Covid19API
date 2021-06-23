package br.com.covid19.exceptions;

public class OccupationException extends RuntimeException{
    public OccupationException() {
        super();
    }

    public OccupationException(String message) {
        super(message);
    }
}
