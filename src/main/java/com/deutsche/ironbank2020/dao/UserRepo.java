package com.deutsche.ironbank2020.dao;

import com.deutsche.ironbank2020.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Integer> {


    @Override
    <S extends User> List<S> saveAll(Iterable<S> iterable);

    @RestResource(path = "byAge")
    List<User> findByAgeGreaterThan(@Param("age") int age);

//    @Override
//    @RestResource(exported = false)
//    <S extends User> S save(S entity);
}
