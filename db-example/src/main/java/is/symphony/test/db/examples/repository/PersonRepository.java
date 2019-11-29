package is.symphony.test.db.examples.repository;

import is.symphony.test.db.examples.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Person findByUsername(String username);

    List<Person> findByLastNameContaining(String lastNameSubstring);
}
