package br.com.covid19.exceptions;

public class DistrictException extends RuntimeException{

    public DistrictException() {
        super();
    }

    public DistrictException(String message) {
        super(message);
    }
}
