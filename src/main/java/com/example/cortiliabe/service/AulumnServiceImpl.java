package com.example.cortiliabe.service;

import com.example.cortiliabe.common.GenericObject;
import com.example.cortiliabe.data.entity.Aulumn;
import com.example.cortiliabe.data.entity.Street;
import com.example.cortiliabe.repository.AulumnRepository;
import com.example.cortiliabe.repository.EducationRepository;
import com.example.cortiliabe.repository.FormationRepository;
import com.example.cortiliabe.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulumnServiceImpl implements AulumnService {

    @Autowired
    AulumnRepository aulumnRepository;

    @Autowired
    StreetRepository streetRepository;

    @Autowired
    FormationRepository formationRepository;

    @Autowired
    EducationRepository educationRepository;

    @Override
    public GenericObject saveAulumn(Aulumn aulumn) {
        if(aulumn==null){
            return  new GenericObject(null,false,"Error");
        }

        if(aulumn.getAddresses()!=null && !aulumn.getAddresses().isEmpty()){
            for (Street street : aulumn.getAddresses()
                 ) {
                streetRepository.save(street);
            }
        }
        if(aulumn.getEducation() != null){
            if(aulumn.getEducation().getMaster() != null){
                formationRepository.save(aulumn.getEducation().getMaster());
            }
            if(aulumn.getEducation().getPhd() !=null){
                formationRepository.save((aulumn.getEducation().getPhd()));
            }
            educationRepository.save(aulumn.getEducation());
        }

        aulumnRepository.save(aulumn);
        return  new GenericObject(null,true,"Aulumn saved on DB");
    }

    @Override
    public List<Aulumn> getAulumn(String name) {
        return aulumnRepository.findAllByName(name);
    }

    @Override
    public Page<Aulumn> getAulumn(String name, Pageable pageable) {
        return aulumnRepository.findAllByName(name,pageable);
    }
}
