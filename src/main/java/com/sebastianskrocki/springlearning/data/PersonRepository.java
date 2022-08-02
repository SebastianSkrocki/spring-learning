package com.sebastianskrocki.springlearning.data;

import com.sebastianskrocki.springlearning.biz.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
}
