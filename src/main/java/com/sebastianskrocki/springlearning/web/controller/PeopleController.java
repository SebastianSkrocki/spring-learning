package com.sebastianskrocki.springlearning.web.controller;

import com.sebastianskrocki.springlearning.biz.model.Person;
import com.sebastianskrocki.springlearning.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonRepository personRepository;
    private Person person;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople(){
        return  personRepository.findAll();
    }
    @ModelAttribute
    public Person getPerson(){
        return new Person();
     }
    @GetMapping
    public String showPeoplePage(){
        return "people";
    }
    @PostMapping
    public String savePerson(@Valid Person person, Errors errors){
        if (!errors.hasErrors()) {
            personRepository.save(person);
            return "redirect:people";
        }
        return "people";
    }
    @PostMapping(params = "delete=true")
    public String deletePeople(@RequestParam Optional<List<Long>> selections){
        System.out.println(selections);
        selections.ifPresent(personRepository::deleteAllById);
        return "redirect:people";
    }
}
