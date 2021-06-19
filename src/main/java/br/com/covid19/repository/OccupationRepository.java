package br.com.covid19.repository;

import br.com.covid19.model.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository<Occupation, Integer> {
}
