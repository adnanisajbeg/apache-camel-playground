package is.symphony.test.db.examples.web;

import is.symphony.test.db.examples.model.Person;
import is.symphony.test.db.examples.model.PersonDTO;
import is.symphony.test.db.examples.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @PostMapping("/add")
    public void addPerson(@RequestBody PersonDTO person) {
        personRepository.save(new Person(person));
    }

    @GetMapping("/findByFirstNameLike")
    public List<PersonDTO> findByFirstNameSubstring(@RequestParam String firstNameSubstring) {
        return personRepository
                .findByLastNameContaining(firstNameSubstring)
                .stream()
                .map(Person::convertToDTO)
                .collect(Collectors.toList());
    }
}
