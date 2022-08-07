package com.sebastianskrocki.springlearning.web.controller;

import com.sebastianskrocki.springlearning.biz.model.Person;
import com.sebastianskrocki.springlearning.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String savePerson(Person person){
        personRepository.save(person);
        return "redirect:people";
    }
    @DeleteMapping
    public String deletePerson(Person person){
        personRepository.delete(person);
        return "redirect:people";
    }
}
