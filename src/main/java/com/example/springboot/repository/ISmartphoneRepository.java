package com.example.springboot.repository;

import com.example.springboot.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {
    Page<Smartphone> findAllByProducerContaining(String search, Pageable pageable);


}
