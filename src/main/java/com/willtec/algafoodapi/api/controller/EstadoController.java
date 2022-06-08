package com.willtec.algafoodapi.api.controller;


import com.willtec.algafoodapi.domain.model.Estado;
import com.willtec.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/estados")
@RestController
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;


    @GetMapping
    public List<Estado> listar(){
        return estadoRepository.findAll();
    }
}
