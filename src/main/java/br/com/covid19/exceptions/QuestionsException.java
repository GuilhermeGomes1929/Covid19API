package br.com.covid19.exceptions;

public class QuestionsException extends RuntimeException{
    public QuestionsException() {
        super();
    }

    public QuestionsException(String message) {
        super(message);
    }
}
