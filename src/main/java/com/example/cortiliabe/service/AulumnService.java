package com.example.cortiliabe.service;

import com.example.cortiliabe.common.GenericObject;
import com.example.cortiliabe.data.entity.Aulumn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AulumnService {

    GenericObject saveAulumn(Aulumn aulumn);

    List<Aulumn> getAulumn(String name);

    Page<Aulumn> getAulumn(String name, Pageable pageable);
}
