package com.example.demo.repository;

import com.example.demo.Entity.CURDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CURDRepo extends JpaRepository<CURDEntity, Long> {

}
