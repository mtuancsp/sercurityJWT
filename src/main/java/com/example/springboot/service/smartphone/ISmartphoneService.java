package com.example.springboot.service.smartphone;

import com.example.springboot.model.Smartphone;
import com.example.springboot.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISmartphoneService extends IGeneralService<Smartphone> {
    Page<Smartphone> findAll(Pageable pageable);

    Page<Smartphone> findAllByProducerContaining(String search, Pageable pageable);
}
