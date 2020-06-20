package pl.adam.firstProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adam.firstProject.model.Card;

public interface CardRepository extends JpaRepository<Card, String> {
}
