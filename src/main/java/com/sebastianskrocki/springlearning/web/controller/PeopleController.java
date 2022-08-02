package com.sebastianskrocki.springlearning.web.controller;

import com.sebastianskrocki.springlearning.biz.model.Person;
import com.sebastianskrocki.springlearning.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PersonRepository personRepository;

//    public PeopleController(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople(){
        return  personRepository.findAll();
    }

    @GetMapping
    public String showPeoplePage(){
        return "people";
    }
}
