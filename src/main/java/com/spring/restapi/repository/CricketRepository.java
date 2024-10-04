package com.spring.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.restapi.model.Cricket;

@Repository
public interface CricketRepository extends JpaRepository<Cricket,Integer>{

}
