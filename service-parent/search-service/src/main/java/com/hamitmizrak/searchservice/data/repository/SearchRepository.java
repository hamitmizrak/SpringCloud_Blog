package com.hamitmizrak.searchservice.data.repository;


import com.hamitmizrak.searchservice.data.entity.SearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Spring 2 sonra @Repository eklemek zorunda değiliz.
@Repository
public interface SearchRepository extends JpaRepository<SearchEntity,Long> {
}
