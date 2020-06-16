package pl.adam.firstProject.repository;

import org.springframework.data.repository.CrudRepository;
import pl.adam.firstProject.model.Trainer;

public interface TrainerRepository extends CrudRepository<Trainer,String> {
}
