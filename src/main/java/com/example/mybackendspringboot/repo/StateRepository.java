package com.example.mybackendspringboot.repo;

import com.example.mybackendspringboot.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<Stat, Long> {
}
