package br.com.covid19;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Covid19Application {

	public static void main(String[] args) throws JsonProcessingException {

		SpringApplication.run(Covid19Application.class, args);

	}

}
