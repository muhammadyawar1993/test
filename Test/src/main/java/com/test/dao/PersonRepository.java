package com.test.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

}
