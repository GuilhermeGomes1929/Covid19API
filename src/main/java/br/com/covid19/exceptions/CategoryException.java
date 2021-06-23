package br.com.covid19.exceptions;

public class CategoryException extends RuntimeException {
    public CategoryException() {
        super();
    }

    public CategoryException(String message) {
        super(message);
    }
}
