package com.adiverse.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.repository.Criteria3Repository;

@Service
public class InputService {
	private final Criteria3Repository inputRepository;

    public InputService(Criteria3Repository inputRepository) {
        this.inputRepository = inputRepository;
    }

    public Iterable<Criteria3_FieldInfo> list() {
        return inputRepository.findAll();
    }

    public Iterable<Criteria3_FieldInfo> save(List<Criteria3_FieldInfo> fieldinfo) {
        return inputRepository.saveAll(fieldinfo);
    }
}
