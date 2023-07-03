package com.example.springboot.service.smartphone;

import com.example.springboot.model.Smartphone;
import com.example.springboot.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(Long id) {
        smartphoneRepository.deleteById(id);
    }

    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return smartphoneRepository.findAll(pageable);
    }

    @Override
    public Page<Smartphone> findAllByProducerContaining(String search, Pageable pageable) {
        return smartphoneRepository.findAllByProducerContaining(search, pageable);
    }
}
