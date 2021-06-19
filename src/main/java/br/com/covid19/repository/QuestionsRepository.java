package br.com.covid19.repository;

import br.com.covid19.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {


}
