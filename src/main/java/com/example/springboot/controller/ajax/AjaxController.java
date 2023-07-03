package com.example.springboot.controller.ajax;

import com.example.springboot.model.Smartphone;
import com.example.springboot.service.smartphone.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/smartphones")
public class AjaxController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public Page<Smartphone> getListPhones(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (search == null || search.equals("")) {
            return smartphoneService.findAll(pageable);
        }
        return smartphoneService.findAllByProducerContaining(search, pageable);
    }

    @DeleteMapping("/{id}")
    public void deleteSmartphone(@PathVariable Long id) {
        smartphoneService.remove(id);
    }

}
