package com.sebastianskrocki.springlearning.data;

import com.sebastianskrocki.springlearning.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Controller
public class PersonDataLoader implements ApplicationRunner {
    private final PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            List<Person> people = List.of(
                    new Person(null, "Sebastian", "Skrocki", LocalDate.of(1999, 11, 23), new BigDecimal("1000")),
                    new Person(null, "Mark", "Mostowiak", LocalDate.of(1989, 1, 17), new BigDecimal("4000")),
                    new Person(null, "Darek", "Wiszak", LocalDate.of(1997, 10, 13), new BigDecimal("12000")),
                    new Person(null, "Katarzyna", "Milewska", LocalDate.of(1996, 6, 20), new BigDecimal("6200"))
            );
            personRepository.saveAll(people);
        }

    }
}
