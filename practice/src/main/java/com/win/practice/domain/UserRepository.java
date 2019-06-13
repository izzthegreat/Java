package com.win.practice.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository <User, Long> {
    List<User> findByLastName (String lastName);
    List<User> findByFirstName (String firstName);
}
