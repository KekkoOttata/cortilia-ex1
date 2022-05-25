package com.example.cortiliabe.controller;

import com.example.cortiliabe.common.GenericObject;
import com.example.cortiliabe.common.ResponseBodyCustom;
import com.example.cortiliabe.data.entity.Aulumn;
import com.example.cortiliabe.data.entity.Street;
import com.example.cortiliabe.service.AulumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.example.cortiliabe.util.Util.isNumeric;

@RestController
@RequestMapping(value = "/api/aulumns/")
public class AulumnController {

    @Autowired
    AulumnService aulumnService;

    @PostMapping(value = "v1/save")
    public GenericObject saveAulumn(@RequestBody Aulumn aulumn){
        return aulumnService.saveAulumn(aulumn);
    }

    @GetMapping(value = "v1/get")
    public ResponseEntity getAulumn(@RequestParam String name){
        List<Aulumn> aulumns = aulumnService.getAulumn(name);
        if(aulumns != null && !aulumns.isEmpty() ){
            ResponseBodyCustom response = new ResponseBodyCustom((long) aulumns.size(),aulumns);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "v2/get")
    public ResponseEntity getAulumnPag(@RequestParam String name,@RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Aulumn> aulumns = aulumnService.getAulumn(name,pageable);
        if(aulumns != null && !aulumns.isEmpty() ){
            ResponseBodyCustom response = new ResponseBodyCustom((long) aulumns.getContent().size(),aulumns);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "v2/save")
    public GenericObject saveAulumnCheck(@RequestBody Aulumn aulumn){
        boolean check = true;
        if(aulumn.getAddresses()!=null && !aulumn.getAddresses().isEmpty()){
            for (Street street : aulumn.getAddresses()
            ) {
                if(street.getStreet() == null || street.getNumber() == null || street.getCountry() == null ){
                    check= false;
                    break;
                }
            }
        }

        if(check) {
            return aulumnService.saveAulumn(aulumn);
        }else{
            return new GenericObject(null,false,"Addresses are incomplete or wrong");
        }
    }

    @PostMapping(value = "v3/save")
    public GenericObject saveAulumnCheck2(@RequestBody Aulumn aulumn){
        boolean check = true;
        if(aulumn.getAddresses()!=null && !aulumn.getAddresses().isEmpty()){
            for (Street street : aulumn.getAddresses()
            ) {
                if(street.getStreet() == null || street.getNumber() == null || street.getCountry() == null || street.getStreet().matches(".*[0-9].*")|| !isNumeric(street.getNumber()) ){
                    check= false;
                    break;
                }
            }
        }
        if(check) {
            return aulumnService.saveAulumn(aulumn);
        }else{
            return new GenericObject(null,false,"Addresses are incomplete or wrong");
        }
    }






}
